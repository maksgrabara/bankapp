package com.maxtheraven.bankapp.code.service;

import com.maxtheraven.bankapp.code.model.User;
import com.maxtheraven.bankapp.code.repository.UserRepository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

import static java.security.MessageDigest.getInstance;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean userExistsID(String id) {
        return userRepository.existsById(id);
    }

    public boolean userExistsLogin(String login) {
        return userRepository.existsByLogin(login);
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

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing algorithm not available", e);
        }
    }

    public boolean userCheckPassword (String pwd, String userID){

        User user = userRepository.findById(userID).orElseThrow(() -> new IllegalArgumentException("UserData not found"));

        String hashedPwd = hashPassword(pwd);

        return user.getPassword().equals(hashedPwd);
    }

    public boolean passwordStrength (String pwd){

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

    public String register(RegisterRequest request) {

        if (request.firstName() == null || request.firstName().isBlank()) {
            throw new InvalidInputException("First name cannot be empty");
        }

        if (request.lastName() == null || request.lastName().isBlank()) {
            throw new InvalidInputException("Last name cannot be empty");
        }

        if (!passwordValidator.isStrong(request.password())) {
            throw new WeakPasswordException("Password does not meet strength requirements");
        }

        String userId = userIdGenerator.generate(request.firstName(), request.lastName());
        String login = loginGenerator.generate(request.firstName(), request.lastName());
        String passwordHash = passwordEncoder.encode(request.password());

        User user = new User(
                userId,
                login,
                request.firstName(),
                request.lastName(),
                request.birthDate(),
                passwordHash
        );

        userRepository.save(user);

        return login;
    }

    public boolean login(String login, String rawPassword) {

        User user = userRepository.findByLogin(login).orElseThrow(() -> new IllegalArgumentException("User not found"));

        return userCheckPassword(rawPassword, user.getUserID());
    }


}

