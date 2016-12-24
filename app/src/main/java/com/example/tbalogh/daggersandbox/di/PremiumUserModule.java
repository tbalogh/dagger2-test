package com.example.tbalogh.daggersandbox.di;

import com.example.tbalogh.daggersandbox.model.User;

import java.util.LinkedHashSet;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.IntoSet;

@Module
public class PremiumUserModule {
    private final static int MAX_USER_COUNT = 10;

    // Egy elemet beletesz abba a Set<> - be ami a @PremiumUsers minositovel lesz ellatva.
    @Provides
    @IntoSet
    @PremiumUsers
    User premiumUser() {
        return new User(MAX_USER_COUNT, "PremiumUser " + MAX_USER_COUNT);
    }

    // Tobb elemet beletesz abba a Set<> - be ami a @PremiumUsers minositovel lesz ellatva.
    @Provides
    @ElementsIntoSet
    @PremiumUsers
    Set<User> premiumUsers() {
        Set<User> userList = new LinkedHashSet<>();
        for (int id = 0; id < MAX_USER_COUNT; id++) {
            userList.add(new User(id, "PremiumUser " + id));
        }
        return userList;
    }
}
