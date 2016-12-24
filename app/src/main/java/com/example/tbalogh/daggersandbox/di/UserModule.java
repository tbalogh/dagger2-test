package com.example.tbalogh.daggersandbox.di;

import com.example.tbalogh.daggersandbox.model.User;
import com.example.tbalogh.daggersandbox.model.UserRepository;
import com.example.tbalogh.daggersandbox.model.UserRepositoryImpl;

import java.util.Set;

import dagger.Module;
import dagger.Provides;

@Module(includes = PremiumUserModule.class)
public class UserModule {

    @Provides
    UserRepository userRepository(@PremiumUsers Set<User> premiumUserList) {
        return new UserRepositoryImpl(premiumUserList);
    }
}
