package com.maxtheraven.bankapp.code.model;

public class User {

    private String userID;
    private String login;
    String uname;
    String ulastname;
    String ubdate;
    String password;
    public User( String userID, String login, String uname, String ulastname, String ubdate, String password){
        this.login = login;
        this.userID = userID;
        this.uname = uname;
        this.ulastname = ulastname;
        this.ubdate = ubdate;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getUserID() {
        return userID;
    }

    public String getUname() {
        return uname;
    }

    public String getUlastname() {
        return ulastname;
    }

    public String getUbdate() {
        return ubdate;
    }

    public String getPassword() {
        return password;
    }
}
