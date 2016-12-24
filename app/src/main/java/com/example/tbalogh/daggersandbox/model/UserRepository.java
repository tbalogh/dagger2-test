package com.example.tbalogh.daggersandbox.model;

import com.annimon.stream.Optional;

import java.util.Collection;

public interface UserRepository {
    Collection<User> users();
    Optional<User> user(int userId);
}
