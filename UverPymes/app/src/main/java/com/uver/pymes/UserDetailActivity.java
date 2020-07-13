package com.uver.pymes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;
import com.uver.pymes.fragment.UserDetailMainFragment;
import com.uver.pymes.fragment.UserDetailTabsAdapter;
import com.uver.pymes.object.Skill;
import com.uver.pymes.object.User;

public class UserDetailActivity extends AppCompatActivity {

    private final String LOGGER = "UserDetailActivity";

    private boolean isAdmin;
    private ImageView imageView;
    private FlexboxLayout lySkills;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_detail);

        imageView = findViewById(R.id.user_detail_iv);
        lySkills = findViewById(R.id.user_detail_ly_skills);

        int id = getIntent().getIntExtra("id", 0);
        isAdmin = getIntent().getBooleanExtra("isAdmin", false);
        String img = getIntent().getStringExtra("img");
        getUserData(id, img);
    }

    private void buildTabLayout(){
        tabLayout = findViewById(R.id.user_detail_tablayout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.userDetailLayout_tab_detail));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.userDetailLayout_tab_courses));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.userDetailLayout_tab_feedback));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = findViewById(R.id.user_detail_viewpager);
        UserDetailTabsAdapter tabsAdapter = new UserDetailTabsAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabsAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void getUserData(final int id, final String img){
        String url = "http://3.83.6.227:23412/eStaffingDraftService/api/talent";
        AndroidNetworking.get(url)
                .addQueryParameter("id", String.valueOf(id))
                .build()
                .getAsObject(User.class, new ParsedRequestListener<User>(){
                    @Override
                    public void onResponse(User response) {
                        UserDetailMainFragment.newInstance(response, isAdmin);
                        // Todo Remove
                        response.setUserImg(img);
                        if( !response.getUserImg().isEmpty()){
                            Picasso.with(getBaseContext()).load(response.getUserImg()).into(imageView);
                        }
                        if( response.getSkills() != null ) {
                            for(Skill s : response.getSkills()){
                                lySkills.addView(createTextViewSkill(s.getName()));
                            }
                        }
                        buildTabLayout();
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(LOGGER, anError.toString());
                    }
                });
    }

    private TextView createTextViewSkill(String text) {
        TextView textView = new TextView(getBaseContext());
        textView.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ActionBar.LayoutParams.WRAP_CONTENT,
                        ActionBar.LayoutParams.WRAP_CONTENT));
        textView.setText(text);
        textView.setTextSize(20);
        textView.setTextColor(Color.WHITE);
        textView.setBackgroundResource(R.drawable.rounded_corner);
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(20, 20, 20, 20);
        return textView;
    }
}