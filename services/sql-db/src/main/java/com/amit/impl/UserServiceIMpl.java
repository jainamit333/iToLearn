package com.amit.impl;

import com.amit.impl.entity.Users;
import com.amit.impl.repo.UserRepository;
import com.amit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by amit on 2/6/16.
 */
@Component
public class UserServiceIMpl implements UserService{

    @Autowired
    UserRepository userRepository;

    public Users saveUser(Users users) {
        return userRepository.save(users);
    }

    public Users getUserById(String id) {
        return userRepository.findOne(id);
    }

    public Users getUserByEmail(String email) {
        return userRepository.findByEmailId(email);
    }

    public void deleteUser(String id) {
        userRepository.delete(id);
    }
}
