package com.uver.pymes.services;

import android.util.Log;

import com.androidnetworking.interfaces.ParsedRequestListener;
import com.uver.pymes.object.Cache;
import com.uver.pymes.object.User;
import com.uver.pymes.object.UserResponse;

import java.util.ArrayList;
import java.util.List;

public class TalentService extends RestClient {

    private final String path = "/talent";

    public void getUsers(int userId, ParsedRequestListener request) {
        Log.d(LOGGER, "Getting user in service");
        final List<UserResponse> userResponseList = new ArrayList<>();
        String url = host.concat(estafingContext).concat(path).concat("/findByUser");
        buildGet(url).addQueryParameter("userId", String.valueOf(userId))
                .addHeaders("Authorization", "Bearer " + Cache.token)
                .build()
                .getAsObjectList(UserResponse.class, request);
    }

    public void getUserDetail(int id, ParsedRequestListener request) {
        Log.d(LOGGER, "Getting user by id");
        String url = host.concat(estafingContext).concat(path);
        buildGet(url).addQueryParameter("id", String.valueOf(id))
                .addHeaders("Authorization", "Bearer " + Cache.token)
                .build()
                .getAsObject(User.class, request);
    }
}
