package com.maxtheraven.bankapp.code.repository;

public interface UserDataRepository {

    void save(String userId, UserData userData);

    Optional<UserData> findByUserId(String userId);

    boolean existsByUserId(String userId);
}
