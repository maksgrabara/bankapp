package com.maxtheraven.bankapp.code.repository;

import com.maxtheraven.bankapp.model.User;
import java.util.*;

public class InMemoryUserRepository implements UserRepository{

    @Override
    public void save(User user) {}

    @Override
    public Optional<User> findByLogin(String login) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.empty();
    }

    @Override
    public boolean existsByLogin(String login) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }
}
