package com.maxtheraven.bankapp.code.service;

import com.maxtheraven.bankapp.code.model.User;
import com.maxtheraven.bankapp.code.model.UserData;
import com.maxtheraven.bankapp.code.repository.UserRepository;
import com.maxtheraven.bankapp.code.repository.UserDataRepository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static java.security.MessageDigest.getInstance;

public class UserService {

    private final UserRepository userRepository;
    private final UserDataRepository userDataRepository;

    public UserService(UserRepository userRepository, UserDataRepository userDataRepository) {
        this.userRepository = userRepository;
        this.userDataRepository = userDataRepository;
    }

    public boolean userExistsID(String id) {
        return userRepository.findById(id).isPresent();
    }

    public boolean userExistsLogin(String login) {
        return userRepository.findByLogin(login).isPresent();
    }

    public String hashPassword(String pwd) {

        try {
            MessageDigest digest = getInstance("SHA-256");
            byte[] hash = digest.digest(pwd.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        }

        catch (NoSuchAlgorithmException e) throw new RuntimeException("Hashing algorithm not available", e);
    }

    public boolean userCheckPassword(String pwd, String userID) {

        UserData userData = userDataRepository.findByUserId(userID).orElseThrow(() -> new IllegalArgumentException("UserData not found"));

        String hashedPwd = hashPassword(pwd);

        return userData.getPassword().equals(hashedPwd);
    }

    public boolean passwordStrength(String pwd) {

        if (pwd.length() < 8) return false;
        if (pwd.chars().anyMatch(Character::isWhitespace)) return false;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        String specials = "!@#$%^&*()-_=+[]{};:',.<>/?|";

        for (char ch : pwd.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (specials.indexOf(ch) >= 0) hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

}
