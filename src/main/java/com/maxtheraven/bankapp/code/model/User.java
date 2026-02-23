package com.maxtheraven.bankapp.code.model;

public class User {

    private String userID;
    private String login;
    public User( String userID, String login){
        this.login = login;
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public String getUserID() {
        return userID;
    }
}
