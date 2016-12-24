package com.example.tbalogh.daggersandbox.di;

import com.example.tbalogh.daggersandbox.userdetails.UserDetailsFragment;
import com.example.tbalogh.daggersandbox.userdetails.UserDetailsPresenter;

import dagger.Component;

@Component(modules = UserDetailsModule.class)
public interface UserDetailsComponent {
    void inject(UserDetailsFragment userDetailsFragment);

    UserDetailsPresenter userDetailsPresenter();
}
