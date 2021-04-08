package com.uver.pymes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.uver.pymes.custom.MyUsersListAdapter;
import com.uver.pymes.object.UserResponse;
import com.uver.pymes.services.TalentService;

import java.util.ArrayList;
import java.util.List;

public class MyUsersListActivity extends Activity implements SearchView.OnQueryTextListener {

    private final String LOGGER =  this.getClass().getName();

    private TalentService talentService;

    private boolean isAdmin;
    private ListView listView;
    private SearchView searchView;
    private List<UserResponse> userResponseList;
    private MyUsersListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_users_list);
        int userId = getIntent().getIntExtra("userId", 0);
        isAdmin = getIntent().getBooleanExtra("isAdmin", false);
        listView = findViewById(R.id.my_users_lv);
        searchView = findViewById(R.id.my_users_sv_search);
        getMyUsers(userId);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(LOGGER, "Element " + i + " clicked");
                Intent intentToDetail = new Intent(getBaseContext(), UserDetailActivity.class);
                intentToDetail.putExtra("isAdmin", isAdmin);
                intentToDetail.putExtra("id", userResponseList.get(i).getId());
                startActivity(intentToDetail);
            }
        });

        searchView.setOnQueryTextListener(this);
    }

    private void getMyUsers(int userId){
        talentService = new TalentService();
        talentService.getUsers(userId, new ParsedRequestListener<ArrayList<UserResponse>>(){

            @Override
            public void onResponse(ArrayList<UserResponse> response) {
                Log.d(LOGGER, response.toString());
                userResponseList = response;
                listAdapter = new MyUsersListAdapter(getApplicationContext(), response);
                listView.setAdapter(listAdapter);
            }

            @Override
            public void onError(ANError anError) {
                Log.d(LOGGER, anError.getMessage());
                Toast.makeText(getApplicationContext(), R.string.search_not_found, Toast.LENGTH_SHORT).show();
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