package com.example.tbalogh.daggersandbox.userdetails;

import com.annimon.stream.Optional;
import com.example.tbalogh.daggersandbox.model.User;
import com.example.tbalogh.daggersandbox.model.UserRepository;

import javax.inject.Inject;

public class UserDetailsPresenterImpl implements UserDetailsPresenter {

    private final int userId;
    private final UserRepository userRepository;

    private UserDetailsView userDetailsView;

    @Inject
    public UserDetailsPresenterImpl(int userId, UserRepository userRepository) {
        this.userId = userId;
        this.userRepository = userRepository;
    }

    @Override
    public void attachView(UserDetailsView userDetailsView) {
        this.userDetailsView = userDetailsView;
        this.userDetailsView.showUser(getUser());
    }

    @Override
    public void detachView(UserDetailsView userDetailsView) {
        if (this.userDetailsView == userDetailsView) {
            this.userDetailsView = null;
        }
    }

    private Optional<User> getUser() {
        return userRepository.user(userId);
    }
}
