package com.amit.controller;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.Post;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by amit on 29/6/16.
 */
@RestController
@RequestMapping(value = "/social")
public class SocialController {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;


    @Inject
    SocialController(Facebook facebook, ConnectionRepository connectionRepository){
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping(value = "facebook",method= RequestMethod.GET)
    public String testFaceBook(){
        if(connectionRepository.findPrimaryConnection(Facebook.class)!=null){
            facebook.userOperations().getUserProfile();
            return "CONNECTED";
        }else{}
        return "NOTCONNECTED";
    }


    @RequestMapping(value = "facebook/profile",method= RequestMethod.GET)
    public PagedList<Post> testFaceBookUserProfile(){
        if(connectionRepository.findPrimaryConnection(Facebook.class)!=null){
            //return facebook.userOperations().getUserProfile();
            return facebook.feedOperations().getFeed();

        }else{}
        return null;
    }

}
