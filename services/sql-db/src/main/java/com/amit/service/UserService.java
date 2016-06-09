package com.amit.service;

import com.amit.impl.entity.Users;

/**
 * Created by amit on 2/6/16.
 */
public interface UserService {


    public Users saveUser(Users user);
    public Users getUserById(String id);
    public Users getUserByEmail(String email);
    public void deleteUser(String id);

}
