package com.maxtheraven.bankapp.code.model;

public class UserData {

    String userID;
    String login;
    String uname;
    String ulastname;
    String ubdate;
    String password;

    public UserData(String userID,
                    String login,
                    String uname,
                    String ulastname,
                    String ubdate,
                    String password){

        this.userID = userID;
        this.login = login;
        this.uname = uname;
        this.ulastname = ulastname;
        this.ubdate = ubdate;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public String getLogin() {
        return login;
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
