package com.example.tbalogh.daggersandbox.userdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.annimon.stream.Optional;
import com.example.tbalogh.daggersandbox.R;
import com.example.tbalogh.daggersandbox.di.DaggerUserDetailsComponent;
import com.example.tbalogh.daggersandbox.di.UserDetailsComponent;
import com.example.tbalogh.daggersandbox.di.UserDetailsModule;
import com.example.tbalogh.daggersandbox.model.User;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailsFragment extends Fragment implements UserDetailsView {

    private static final String KEY_USER_ID = "user-id";
    public static final String TAG = "UserDetailsFragment";

    @BindView(R.id.tv_username)
    TextView userNameTextView;

    @Inject
    UserDetailsPresenter userDetailsPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;

        int userId = getArguments().getInt(KEY_USER_ID);
        UserDetailsComponent component = DaggerUserDetailsComponent.builder()
                .userDetailsModule(new UserDetailsModule(userId))
                .build();
        component.inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onResume() {
        super.onResume();
        userDetailsPresenter.attachView(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        userDetailsPresenter.detachView(this);
    }

    @Override
    public void showUser(Optional<User> user) {
        if (user.isPresent()) {
            userNameTextView.setText(user.get().getName());
        } else {
            userNameTextView.setText("User not found.");
        }
    }

    public static Fragment newInstance(int userId) {
        UserDetailsFragment fragment = new UserDetailsFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(KEY_USER_ID, userId);
        fragment.setArguments(arguments);
        return fragment;
    }
}
