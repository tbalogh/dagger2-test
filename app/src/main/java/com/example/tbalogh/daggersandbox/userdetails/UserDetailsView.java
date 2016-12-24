package com.example.tbalogh.daggersandbox.userdetails;

import com.annimon.stream.Optional;
import com.example.tbalogh.daggersandbox.model.User;

public interface UserDetailsView {
    void showUser(Optional<User> user);
}
