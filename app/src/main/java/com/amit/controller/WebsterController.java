package com.amit.controller;


import com.amit.webster.WebPageUserStat;
import com.amit.webster.CoreWebsterService;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.TextFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;

/**
 * Created by amit on 24/6/16.
 */
@RestController
@RequestMapping(value = "/webster")
public class WebsterController {

    @Autowired
    private CoreWebsterService coreWebsterService;

    @Produces("application/x-protobuf")
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

    @RequestMapping(value = "webpage/userstat",method = RequestMethod.POST)
    public String postUserWebpageData(@RequestBody String value) throws InvalidProtocolBufferException, TextFormat.ParseException {
        try{
            WebPageUserStat.WebPageUserStats.Builder builder = WebPageUserStat.WebPageUserStats.newBuilder();
            TextFormat.getParser().merge(value,builder);
            WebPageUserStat.WebPageUserStats webPageUserStats = builder.build();
            coreWebsterService.addUserStat(webPageUserStats.getUserId(),webPageUserStats);
            return "SUCCESS";
        }catch (Exception e){
            return "FAIL";
        }
    }

    @RequestMapping(value = "/webpage/userstat",method = RequestMethod.PUT)
    public String putUserWebpageData(@RequestBody String value){
        try{
            WebPageUserStat.WebPageUserStats.Builder builder = WebPageUserStat.WebPageUserStats.newBuilder();
            TextFormat.getParser().merge(value,builder);
            WebPageUserStat.WebPageUserStats webPageUserStats = builder.build();
            coreWebsterService.updateUserStat(webPageUserStats.getUserId(),webPageUserStats);
            return "SUCCESS";
        }catch (Exception e){
            return "FAIL";
        }
    }
    @RequestMapping(value = "/webpage/userstat",method = RequestMethod.GET)
    public String getUserWebpageData(@RequestParam String userid,@RequestParam String webpage){
        return coreWebsterService.getUserStatForWebpage(userid,webpage).toString();
    }

    @RequestMapping(value = "/webpage/stat",method = RequestMethod.GET)
    public String getWebpageData(@RequestParam String webpage){
        return coreWebsterService.getWebPageStat(webpage).toString();
    }

    @RequestMapping(value = "/userStat",method = RequestMethod.GET)
    public long getUserData(@RequestParam String userId){
        return coreWebsterService.getUserStat(userId);
    }

}
