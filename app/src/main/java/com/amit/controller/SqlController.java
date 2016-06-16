package com.amit.controller;

import com.amit.impl.entity.Users;
import com.amit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amit on 8/6/16.
 */
@RestController
@RequestMapping("/sql")
public class SqlController {


    @Autowired
    UserService userService;

    @RequestMapping("/add")
    public String addNewUser(){

        Users users
                 = new Users();
        users.setFirstName("Amit");
        users.setEmailId("jainamit333@gmail.com");
        users.setLastName("Jain");
        users.setPhoneNumber("9902680668");
        userService.saveUser(users);

        return "added ";
    }
}
