package com.maxtheraven.bankapp.code.repository;

import com.maxtheraven.bankapp.model.User;
import java.util.Optional;
import java.util.List;

public interface UserRepository {

    void save(User user);

    Optional<User> findByLogin(String login);

    Optional<User> findById(String id);

    boolean existsByLogin(String login);

    List<User> findAll();
}
