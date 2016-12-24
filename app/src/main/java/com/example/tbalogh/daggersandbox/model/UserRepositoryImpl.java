package com.example.tbalogh.daggersandbox.model;

import com.annimon.stream.Optional;
import com.annimon.stream.Stream;

import java.util.Collection;

import javax.inject.Inject;

public class UserRepositoryImpl implements UserRepository {

    private Collection<User> userList;

    @Inject
    public UserRepositoryImpl(Collection<User> userList) {
        this.userList = userList;
    }

    @Override
    public Collection<User> users() {
        return userList;
    }

    @Override
    public Optional<User> user(int userId) {
        return Stream.of(userList)
                .filter(user -> user.getId() == userId)
                .findFirst();
    }
}
