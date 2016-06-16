package com.amit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amit on 2/6/16.
 */
@RestController
@RequestMapping(value = "/rest")
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        return "I am Up";
    }
}
