package com.maxtheraven.bankapp.code.repository;

import com.maxtheraven.bankapp.code.model.User;
import java.util.*;
import java.util.List;

public class InMemoryUserRepository implements UserRepository{

    private final Map<String, User> usersById = new HashMap<>();
    private final Map<String, User> usersByLogin = new HashMap<>(); // 2 maps allow for O(1) lookups regardless of whether we're looking by ID or login

    @Override
    public void save(User user) {
        usersById.put(user.getUserID(), user);
        usersByLogin.put(user.getLogin(), user);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return Optional.ofNullable(usersByLogin.get(login));
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(usersById.get(id));
    }

    @Override
    public boolean existsByLogin(String login) {
        return usersByLogin.containsKey(login);
    }

    @Override
    public boolean existsById(String id) {
        return usersById.containsKey(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(usersById.values());
    }
}
