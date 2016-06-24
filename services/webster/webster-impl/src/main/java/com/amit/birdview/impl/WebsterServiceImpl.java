package com.amit.birdview.impl;


import com.amit.couch.api.CouchDocument;
import com.amit.couch.api.CouchService;


import com.amit.webster.api.WebPageStat;
import com.amit.webster.api.WebPageUserStat;
import com.amit.webster.api.Webpage;
import com.amit.webster.api.WebsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by amit on 24/6/16.
 */
@Component
public class WebsterServiceImpl implements WebsterService {

    @Autowired
    CouchService couchBaseService;

    public void addUserStat(String userId, WebPageUserStat.WebPageUserStats webPageStats) {

        CouchDocument couchDocument = new CouchDocument<WebPageUserStat.WebPageUserStats>();
        couchDocument.setId("WEBVIEW-"+"USERSTAT-"+userId+"-"+webPageStats.getCompleteUrl());
        couchDocument.setDocument(webPageStats);
        couchBaseService.add(couchDocument);

    }

    public void addWebPageStat(WebPageStat.WebPageStats webPageStats) {
        CouchDocument couchDocument = new CouchDocument<WebPageStat.WebPageStats>();
        couchDocument.setId("WEBVIEW-"+"WEBPAGESTAT-"+webPageStats.getCompleteUrl());
        couchDocument.setDocument(webPageStats);
        couchBaseService.add(couchDocument);
    }

    public void updateUserStat(String userId, WebPageUserStat.WebPageUserStats webPageStats) {

        WebPageUserStat.WebPageUserStats prevStat = (WebPageUserStat.WebPageUserStats) couchBaseService.get("WEBVIEW-"+"USERSTAT-"+userId+"-"+webPageStats.getCompleteUrl());
        int likeCounter = 0;
        if(prevStat.getLike() && !webPageStats.getLike())
            likeCounter--;
        if(!prevStat.getLike() && webPageStats.getLike())
            likeCounter++;
        addUserStat(userId,webPageStats);
        WebPageStat.WebPageStats prevWebStat = (WebPageStat.WebPageStats) couchBaseService.get("WEBVIEW-"+"WEBPAGESTAT-"+webPageStats.getCompleteUrl());
        WebPageStat.WebPageStats newWebStat = WebPageStat.WebPageStats.newBuilder().setBaseUrl(prevStat.getBaseUrl()).setCompleteUrl(prevStat.getCompleteUrl())
                .setHeader(prevWebStat.getHeader()).setLikes(prevWebStat.getLikes()+likeCounter).addAllMetadata(prevWebStat.getMetadataList()).addAllTag(prevWebStat.getTagList()).build();
        addWebPageStat(newWebStat);

    }

    public WebPageUserStat.WebPageUserStats getUserStatForWebpage(String userId, String webpage) {

        return (WebPageUserStat.WebPageUserStats) couchBaseService.get("WEBVIEW-"+"USERSTAT-"+userId+"-"+webpage);
    }

    public WebPageStat.WebPageStats getWebPageStat(String webpage) {
        return (WebPageStat.WebPageStats) couchBaseService.get("WEBVIEW-"+"WEBPAGESTAT-"+webpage);
    }


}
