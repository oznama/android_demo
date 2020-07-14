package com.oznama.poc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.oznama.poc.beans.User;
import com.oznama.poc.utils.DBDummy;

public class RegisterActivity extends AppCompatActivity {

    private EditText etFirstName, etLastName, etUsername, etPassword, etRePassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findAllElements();
    }

    private void findAllElements(){
        etUsername = findViewById(R.id.reg_et_username);
        etPassword = findViewById(R.id.reg_et_password);
        etRePassword = findViewById(R.id.reg_et_repassword);
        btnRegister = findViewById(R.id.reg_btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String rePassword = etRePassword.getText().toString();
                if( !username.isEmpty() && !password.isEmpty() && !rePassword.isEmpty() && password.equals(rePassword) ){
                    DBDummy.USERS.add( new User(username, password) );
                    Toast.makeText(getBaseContext(), R.string.register_user_created, Toast.LENGTH_LONG).show();
                    Intent main = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(main);
                } else {
                    Toast.makeText(getBaseContext(), R.string.register_user_not_created, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}