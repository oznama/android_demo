package com.uver.pymes;

import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MenuActivity extends Activity {

    private final String LOGGER =  this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        CardView cardViewOpt1 = findViewById(R.id.menu_cv_opt1);
        cardViewOpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToMyUsers = new Intent(getBaseContext(), MyUsersListActivity.class);
                intentToMyUsers.putExtra("userId", 1);
                intentToMyUsers.putExtra("isAdmin", true);
                startActivity(intentToMyUsers);
            }
        });

        CardView cardViewOpt2 = findViewById(R.id.menu_cv_opt2);
        cardViewOpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOGGER, "Clicked 2");
            }
        });

        CardView cardViewOpt3 = findViewById(R.id.menu_cv_opt3);
        cardViewOpt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOGGER, "Clicked 3");
            }
        });

        CardView cardViewOpt4 = findViewById(R.id.menu_cv_opt4);
        cardViewOpt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOGGER, "Clicked 4");
            }
        });

        CardView cardViewOpt5 = findViewById(R.id.menu_cv_opt5);
        cardViewOpt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOGGER, "Clicked 5");
            }
        });

        CardView cardViewOpt6 = findViewById(R.id.menu_cv_opt6);
        cardViewOpt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOGGER, "Clicked 6");
            }
        });
    }
}