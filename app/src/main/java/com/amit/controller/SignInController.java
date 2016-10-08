package com.amit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by amit on 29/6/16.
 */
@Controller
public class SignInController {

    @RequestMapping(value="/signin", method= RequestMethod.GET)
    public void signin() {
    }
}
