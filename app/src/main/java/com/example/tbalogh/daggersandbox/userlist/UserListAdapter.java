package com.example.tbalogh.daggersandbox.userlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tbalogh.daggersandbox.R;
import com.example.tbalogh.daggersandbox.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private final LayoutInflater layoutInflater;
    private final List<User> userList;

    private UserClickedListener userClickedListener;

    UserListAdapter(LayoutInflater layoutInflater) {
        this.userList = new ArrayList<>();
        this.layoutInflater = layoutInflater;
    }

    void update(Collection<User> users) {
        userList.clear();
        userList.addAll(users);
        Collections.sort(userList, (lhs, rhs) -> lhs.getName().compareTo(rhs.getName()));
        notifyDataSetChanged();
    }

    void setUserClickedListener(UserClickedListener userClickedListener) {
        this.userClickedListener = userClickedListener;
    }

    void removeUserClickedListener(UserClickedListener userClickedListener) {
        if (this.userClickedListener == userClickedListener) {
            this.userClickedListener = null;
        }
    }

    void notifyUserClickedListener(User user) {
        if (userClickedListener != null) {
            userClickedListener.onUserClicked(user);
        }
    }

    void notifyItemClicked(int position) {
        try {
            notifyUserClickedListener(userList.get(position));
        } catch (IndexOutOfBoundsException ignored) {

        }
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.update(userList.get(position));
    }

    interface UserClickedListener {
        void onUserClicked(User user);
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.username) TextView userNameTextView;

        UserViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(view -> {
                UserListAdapter.this.notifyItemClicked(getAdapterPosition());
            });
        }

        void update(User user) {
            userNameTextView.setText(user.getName());
        }
    }
}
