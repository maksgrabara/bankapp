package com.maxtheraven.bankapp.code.generators;

import com.maxtheraven.bankapp.code.model.User;

import java.util.List;
import java.util.Random;

public class Generators {

    public String generateLogin(String uname, String ulastname, List<User> users) {
        Random rand = new Random();
        String newLogin = "";

        String finalNewLogin = newLogin;
        do {
            int randomNum = 1000 + rand.nextInt(9000); // od 1000 do 9999

            String lettersUname = "";
            if (uname != null && !uname.isEmpty()) {
                lettersUname += Character.toUpperCase(uname.charAt(0));
                if (uname.length() > 1) lettersUname += Character.toUpperCase(uname.charAt(uname.length() - 1));
            }

            String lettersUlastname = "";
            if (ulastname != null && !ulastname.isEmpty()) {
                lettersUlastname += Character.toUpperCase(ulastname.charAt(0));
                if (ulastname.length() > 1) lettersUlastname += Character.toUpperCase(ulastname.charAt(ulastname.length() - 1));
            }

            newLogin = lettersUname + lettersUlastname + randomNum;

        } while (users.stream().anyMatch(u -> u.getLogin().equals(finalNewLogin)));

        return newLogin;
    }

    public String generateUserID(String uname, String ulastname, List<User> users) {
        Random rand = new Random();
        String newID = "";

        char firstUname = (uname != null && !uname.isEmpty()) ? Character.toUpperCase(uname.charAt(0)) : 'X';
        char firstUlastname = (ulastname != null && !ulastname.isEmpty()) ? Character.toUpperCase(ulastname.charAt(0)) : 'X';

        String finalNewID = newID;
        do {
            int randomNum = 1000000 + rand.nextInt(9000000); // od 1_000_000 do 9_999_999
            newID = "" + firstUname + firstUlastname + randomNum;
        } while (users.stream().anyMatch(u -> u.getUserID().equals(finalNewID)));

        return newID;
    }
}
