package com.example.tbalogh.daggersandbox.userlist;

import com.example.tbalogh.daggersandbox.model.User;
import com.example.tbalogh.daggersandbox.model.UserRepository;

import java.util.Collection;

import javax.inject.Inject;

public class UserListPresenterImpl implements UserListPresenter {

    private final UserRepository userRepository;

    private UserListView userListView;

    @Inject
    public UserListPresenterImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void attachView(UserListView userListView) {
        this.userListView = userListView;
        this.userListView.showUserList(getUserList());
    }

    @Override
    public void detachView(UserListView userListView) {
        if (this.userListView == userListView) {
            this.userListView = null;
        }
    }

    @Override
    public Collection<User> getUserList() {
        return userRepository.users();
    }
}
