package com.example.tbalogh.daggersandbox.userlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tbalogh.daggersandbox.R;
import com.example.tbalogh.daggersandbox.UserActivity;
import com.example.tbalogh.daggersandbox.di.DaggerUserListComponent;
import com.example.tbalogh.daggersandbox.di.UserListComponent;
import com.example.tbalogh.daggersandbox.model.User;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListFragment extends Fragment implements UserListView, UserListAdapter.UserClickedListener {

    public static final String TAG = "UserListFragment";

    @Inject
    UserListPresenter userListPresenter;

    @BindView(R.id.userlist)
    RecyclerView recyclerView;

    private UserListAdapter userListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_list, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserListComponent component = DaggerUserListComponent.builder().build();
        component.inject(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        userListAdapter = new UserListAdapter(getActivity().getLayoutInflater());
        userListAdapter.setUserClickedListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(userListAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        userListPresenter.attachView(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        userListPresenter.detachView(this);
    }

    @Override
    public void showUserList(Collection<User> userList) {
        userListAdapter.update(userList);
    }

    public static Fragment newInstance() {
        return new UserListFragment();
    }

    @Override
    public void onUserClicked(User user) {
        ((UserActivity)getActivity()).navigateToUserDetails(user);
    }
}
