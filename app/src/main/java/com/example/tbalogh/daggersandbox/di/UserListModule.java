package com.example.tbalogh.daggersandbox.di;

import com.example.tbalogh.daggersandbox.userlist.UserListPresenter;
import com.example.tbalogh.daggersandbox.userlist.UserListPresenterImpl;
import com.example.tbalogh.daggersandbox.model.UserRepository;

import dagger.Module;
import dagger.Provides;

@Module(includes = UserModule.class)
public class UserListModule {

    @Provides
    UserListPresenter userListPresenter(UserRepository userRepository) {
        return new UserListPresenterImpl(userRepository);
    }
}
