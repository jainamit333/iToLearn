package com.amit.controller;

import com.amit.webster.api.WebPageUserStat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amit on 24/6/16.
 */
@RestController
@RequestMapping(value = "/webster")
public class WebsterController {

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String testWebster(){
        return WebPageUserStat.WebPageUserStats.newBuilder().setBaseUrl("developers.google.com")
                .setCompleteUrl("https://developers.google.com/protocol-buffers/docs/javatutorial#compiling-your-protocol-buffers")
                .setHeader("https")
                .setUserId("jainamit333@gmail.com")
                .setLike(false)
                .addTag(WebPageUserStat.WebPageUserStats.Tags.newBuilder().setTag("TAG 0").build())
                .addTag(WebPageUserStat.WebPageUserStats.Tags.newBuilder().setTag("TAG 1").build())
                .addTag(WebPageUserStat.WebPageUserStats.Tags.newBuilder().setTag("TAG 2").build())
                .build().toString();
    }
}
