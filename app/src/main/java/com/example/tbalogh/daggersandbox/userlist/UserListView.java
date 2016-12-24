package com.example.tbalogh.daggersandbox.userlist;

import com.example.tbalogh.daggersandbox.model.User;

import java.util.Collection;

public interface UserListView {
    void showUserList(Collection<User> userList);
}
