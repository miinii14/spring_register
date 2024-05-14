package com.umcs.log_in.service;

import com.umcs.log_in.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);
    String registerUser(User user);
}
