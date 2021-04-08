package com.uver.pymes.services;

import android.util.Log;

import com.androidnetworking.interfaces.ParsedRequestListener;
import com.uver.pymes.object.LoginResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginService extends RestClient {

    public void doLogin(String username, String password, ParsedRequestListener request) {
        Log.d(LOGGER, "Do Login in service");
        String url = host.concat(cognitoContext).concat("/login");

        JSONObject body = new JSONObject();
        try{
            body.put("username", username);
            body.put("password", password);
        }catch (JSONException e){
            Log.e(LOGGER, e.getMessage());
        }

        buildPost(url).addJSONObjectBody(body).build()
                .getAsObject(LoginResponse.class, request);
    }
}
