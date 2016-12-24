package com.example.tbalogh.daggersandbox.di;

import com.example.tbalogh.daggersandbox.model.UserRepository;
import com.example.tbalogh.daggersandbox.userdetails.UserDetailsPresenter;
import com.example.tbalogh.daggersandbox.userdetails.UserDetailsPresenterImpl;

import dagger.Module;
import dagger.Provides;

@Module(includes = UserModule.class)
public class UserDetailsModule {

    private final int userId;

    public UserDetailsModule(int userId) {
        this.userId = userId;
    }

    @Provides
    UserDetailsPresenter userDetailsPresenter(UserRepository userRepository) {
        return new UserDetailsPresenterImpl(userId, userRepository);
    }
}
