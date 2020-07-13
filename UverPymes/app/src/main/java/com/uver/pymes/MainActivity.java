package com.uver.pymes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.uver.pymes.object.GenericResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity {

    private final String LOGGER = this.getClass().getName();

    private EditText edUsername;
    private EditText edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        edUsername = (EditText) findViewById(R.id.ml_et_username);
        edPassword = (EditText) findViewById(R.id.ml_et_password);

        AndroidNetworking.initialize(getApplicationContext());
    }

    /**
     * Redireciona al menu principal
     */
    private void next(){
        Intent intentGoMenu = new Intent(getBaseContext(), MenuActivity.class);
        startActivity(intentGoMenu);
    }

    /**
     * Metodo publico para el layout
     * @param view unused
     */
    public void btnLoginOnClick(View view){
        String username = edUsername.getText().toString();
        String password = edPassword.getText().toString();
        Log.d(LOGGER, "Username: " + username + ", Password: " + password);
        validateDummy(username, password);
    }

    /**
     * Metodo validate user and password dummy
     * @param username cualquier cadena - admin
     * @param password cualquier cadena - 1234
     */
    private void validateDummy(String username, String password){
        if (username.equals("admin") && password.equals("1234")){
            next();
        } else {
            Toast.makeText(getApplicationContext(), R.string.mainLayout_failed, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Metodo que utiliza un servicio rest para login
     * En este caso estamos usando el login de cognito de Stratis XD
     * @param username - correo mystratis
     * @param password - contrasenia
     */
    private void validate(String username, String password){
        String url = "http://3.83.6.227:23412/cognitoauth/rest/auth/login";

        JSONObject body = new JSONObject();
        try{
            body.put("username", username);
            body.put("password", password);
        }catch (JSONException e){
            Log.e(LOGGER, e.getMessage());
        }

        AndroidNetworking.post(url)
                .addJSONObjectBody(body)
                .build()
                .getAsObject(GenericResponse.class, new ParsedRequestListener<GenericResponse>() {
                    @Override
                    public void onResponse(GenericResponse response) {
                        Log.d(LOGGER, response.toString());
                        if( response.getCode() == 100 && response.getStatus().equals("success") ){
                            next();
                        } else
                            Toast.makeText(getApplicationContext(), (String) response.getEntity(), Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d(LOGGER, anError.toString());
                    }
                });
    }
}
