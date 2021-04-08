package com.uver.pymes.object;

public class Entity {

    private Token token;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "token=" + token +
                '}';
    }
}
