package com.uver.pymes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.uver.pymes.custom.MyUsersListAdapter;
import com.uver.pymes.object.UserResponse;

import java.util.ArrayList;

public class MyUsersListActivity extends Activity implements SearchView.OnQueryTextListener {

    private final String LOGGER = "MyUserActivity";

    private boolean isAdmin;
    private ListView listView;
    private SearchView searchView;
    private ArrayList<UserResponse> userResponseList;
    private MyUsersListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_users_list);
        int userId = getIntent().getIntExtra("userId", 0);
        isAdmin = getIntent().getBooleanExtra("isAdmin", false);
        listView = (ListView) findViewById(R.id.my_users_lv);
        searchView = (SearchView) findViewById(R.id.my_users_sv_search);
        getMyUsers(userId);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(LOGGER, "Element " + i + " clicked");
                Intent intentToDetail = new Intent(getBaseContext(), UserDetailActivity.class);
                intentToDetail.putExtra("isAdmin", isAdmin);
                intentToDetail.putExtra("id", userResponseList.get(i).getId());
                intentToDetail.putExtra("img", userResponseList.get(i).getUserImg());
                startActivity(intentToDetail);
            }
        });

        searchView.setOnQueryTextListener(this);
    }

    private void getMyUsers(int userId){
        String url = "http://3.83.6.227:23412/eStaffingDraftService/api/talent/search/findByUser";
        AndroidNetworking.get(url)
                .addQueryParameter("userId", String.valueOf(userId))
                .build()
                .getAsObjectList(UserResponse.class, new ParsedRequestListener<ArrayList<UserResponse>>(){

                    @Override
                    public void onResponse(ArrayList<UserResponse> response) {
                        userResponseList = response;
                        if( response.size()> 3 ){
                            response.get(0).setUserImg("https://upload.wikimedia.org/wikipedia/en/a/a1/NafSadh_Profile.jpg");
                            response.get(2).setUserImg("https://upload.wikimedia.org/wikipedia/commons/a/a7/G-dragon_profile.jpg");
                            response.get(3).setUserImg("https://upload.wikimedia.org/wikipedia/commons/5/56/NaacArt_profile.jpg");
                            response.get(4).setUserImg("https://upload.wikimedia.org/wikipedia/en/8/81/Bee-ho-gray-profile.jpg");
                            response.get(5).setUserImg("https://www.cornerhome.com.mx/portal/public/images/profile/photos/profile_photo_1.png");
                            response.get(6).setUserImg("https://www.cornerhome.com.mx/portal/public/images/profile/photos/profile_photo_9.jpg");
                        }
                        listAdapter = new MyUsersListAdapter(getApplicationContext(), response);
                        listView.setAdapter(listAdapter);
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(LOGGER, anError.toString());
                    }
                });
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        listAdapter.getFilter().filter(s);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        if(s.equals("")){
            this.onQueryTextSubmit("");
        }
        return true;
    }
}