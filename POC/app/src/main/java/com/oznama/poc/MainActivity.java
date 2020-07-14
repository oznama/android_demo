package com.oznama.poc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String LOGGER = "MainActivity";

    private EditText etUsername, etPassword;
    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findAllElements();
    }

    private void findAllElements(){
        this.etUsername = findViewById(R.id.main_et_username);
        this.etPassword = findViewById(R.id.main_et_password);
        this.btnLogin = findViewById(R.id.main_btn_login);
        this.btnRegister = findViewById(R.id.main_btn_register);
        doLogin();
    }

    private void doLogin(){
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                Log.d(LOGGER, String.format("Username: %s, Password: %s", username, password));
                if(username.toLowerCase().equals("oznama27@gmail.com") && password.equals("1234")){
                    Intent menu = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(menu);
                }else{
                    Toast.makeText(getBaseContext(), R.string.main_view_login_fail, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}