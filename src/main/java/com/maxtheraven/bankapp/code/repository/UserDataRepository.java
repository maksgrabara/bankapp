package com.maxtheraven.bankapp.code.repository;

import com.maxtheraven.bankapp.code.model.UserData;
import java.util.Optional;

public interface UserDataRepository {

    void save(String userId, UserData userData);

    Optional<UserData> findByUserId(String userId);

    boolean existsByUserId(String userId);
}
