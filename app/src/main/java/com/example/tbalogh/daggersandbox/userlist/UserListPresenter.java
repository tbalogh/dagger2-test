package com.example.tbalogh.daggersandbox.userlist;

import com.example.tbalogh.daggersandbox.model.User;

import java.util.Collection;

public interface UserListPresenter {
    void attachView(UserListView userListView);

    void detachView(UserListView userListView);

    Collection<User> getUserList();
}
