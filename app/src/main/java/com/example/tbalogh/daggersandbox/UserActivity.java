package com.example.tbalogh.daggersandbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.tbalogh.daggersandbox.model.User;
import com.example.tbalogh.daggersandbox.userdetails.UserDetailsFragment;
import com.example.tbalogh.daggersandbox.userlist.UserListFragment;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showUserListFragment();
    }

    public void navigateToUserDetails(User user) {
        showUserDetailsFragment(user);
    }

    private void showUserDetailsFragment(User user) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, UserDetailsFragment.newInstance(user.getId()));
        transaction.addToBackStack(null);
//        transaction.add(R.id.fragment_container, UserDetailsFragment.newInstance(user.getId()), UserDetailsFragment.TAG);
        transaction.commit();
    }

    private void showUserListFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container, UserListFragment.newInstance());
        transaction.commit();
    }
}
