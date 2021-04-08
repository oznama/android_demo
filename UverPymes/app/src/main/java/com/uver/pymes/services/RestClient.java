package com.uver.pymes.services;

import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.ANRequest;
import com.uver.pymes.object.Result;

import org.json.JSONException;
import org.json.JSONObject;

public class RestClient {

    protected final String LOGGER = this.getClass().getName();

    protected String host = "http://192.168.0.8:8080";
    protected String cognitoContext = "/cognitoauth/rest/auth";
    protected String estafingContext = "/eStaffingDraftService/api";

    protected final Result result;

    public RestClient(){
        this.result = new Result();
    }

    protected JSONObject objectToJson(Object object) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(String.valueOf(object));
            return jsonObject;
        } catch (JSONException e) {
            Log.e(LOGGER, e.getMessage());
            return null;
        }
    }

    protected ANRequest.GetRequestBuilder buildGet(String url) {
        result.setResult(false);
        Log.e(LOGGER, "Building GET to url: " + url);
        return AndroidNetworking.get(url);
    }

    protected ANRequest.PostRequestBuilder buildPost(String url) {
        result.setResult(false);
        Log.e(LOGGER, "Building POST to url: " + url);
        return AndroidNetworking.post(url);
    }
}
