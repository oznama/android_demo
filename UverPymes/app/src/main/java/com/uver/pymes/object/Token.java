package com.uver.pymes.object;

public class Token {

    public String id_token;
    public String refresh_token;

    public String getId_token() {
        return id_token;
    }

    public void setId_token(String id_token) {
        this.id_token = id_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "id_token='" + id_token + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                '}';
    }
}
