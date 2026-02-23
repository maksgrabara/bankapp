package com.maxtheraven.bankapp.code.repository;

import com.maxtheraven.bankapp.model.UserData;
import java.util.*;

public class InMemoryUserDataRepository implements UserDataRepository {

    private final Map<String, UserData> userDataMap = new HashMap<>();

    @Override
    public void save(String userId, UserData userData) {
        userDataMap.put(userId, userData);
    }

    @Override
    public Optional<UserData> findByUserId(String userId) {
        return Optional.ofNullable(userDataMap.get(userId));
    }

    @Override
    public boolean existsByUserId(String userId) {
        return userDataMap.containsKey(userId);
    }
}
