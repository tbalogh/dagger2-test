package com.example.tbalogh.daggersandbox.userdetails;

public interface UserDetailsPresenter {
    void attachView(UserDetailsView userDetailsView);

    void detachView(UserDetailsView userDetailsView);
}
