package com.amit.controller;

import com.amit.tastekit.Testme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amit on 5/7/16.
 */
@RestController
@RequestMapping(value = "/testitkit")
public class TestItController {

    @Autowired
    private Testme testme;

    @RequestMapping(value = "execute",method = RequestMethod.GET)
    public void execute(){
        testme.execute();
    }

}
