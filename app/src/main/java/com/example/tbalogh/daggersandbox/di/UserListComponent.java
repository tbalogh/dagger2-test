package com.example.tbalogh.daggersandbox.di;

import com.example.tbalogh.daggersandbox.userlist.UserListFragment;
import com.example.tbalogh.daggersandbox.userlist.UserListPresenter;

import dagger.Component;

@Component( modules = {UserListModule.class} )
public interface UserListComponent {
    UserListPresenter userListPresenter();

    void inject(UserListFragment userListFragment);
}
