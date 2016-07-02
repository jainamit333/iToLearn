package com.amit.webster.impl;


import com.amit.couch.api.CouchDocument;
import com.amit.couch.api.CouchService;
import com.amit.impl.entity.WebsterLog;
import com.amit.webster.CoreWebsterService;
import com.amit.webster.WebPageStat;
import com.amit.webster.WebPageUserStat;
import com.google.protobuf.TextFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by amit on 24/6/16.
 */
@Component
public class CoreWebsterServiceImpl implements CoreWebsterService {

    @Autowired
    private CouchService couchBaseService;

    @Autowired
    private com.amit.service.WebsterService websterService;

    public void addUserStat(String userId, WebPageUserStat.WebPageUserStats webPageStats) throws TextFormat.ParseException {

        WebPageUserStat.WebPageUserStats.Builder builder = WebPageUserStat.WebPageUserStats.newBuilder();
        String data = (String)couchBaseService.get("WEBVIEW-"+"USERSTAT-"+userId+"-"+webPageStats.getCompleteUrl());
        if(data!=null){
            TextFormat.getParser().merge(data,builder);
            WebPageUserStat.WebPageUserStats prevStat =  builder.build();
            if(prevStat!=null){
                int likeCounter = 0;
                if(prevStat.getLike() && !webPageStats.getLike())
                    likeCounter--;
                if(!prevStat.getLike() && webPageStats.getLike())
                    likeCounter++;
                updateWebPageStat(webPageStats.getCompleteUrl(),likeCounter,webPageStats);
            }
        }else{
            int likeCounter = webPageStats.getLike()?1:0;
            updateWebPageStat(webPageStats.getCompleteUrl(),likeCounter,webPageStats);
        }
        CouchDocument couchDocument = new CouchDocument<String>();
        couchDocument.setId("WEBVIEW-"+"USERSTAT-"+userId+"-"+webPageStats.getCompleteUrl());
        couchDocument.setDocument(webPageStats.toString());
        couchBaseService.add(couchDocument);

        WebsterLog websterLog = new WebsterLog();
        websterLog.setUserId(userId);websterLog.setCouchKey("WEBVIEW-"+"USERSTAT-"+userId+"-"+webPageStats.getCompleteUrl());
        websterLog.setWebpage(webPageStats.getCompleteUrl());
        websterService.add(websterLog);

    }

    public void addWebPageStat(WebPageStat.WebPageStats webPageStats) {
        CouchDocument couchDocument = new CouchDocument<WebPageStat.WebPageStats>();
        couchDocument.setId("WEBVIEW-"+"WEBPAGESTAT-"+webPageStats.getCompleteUrl());
        couchDocument.setDocument(webPageStats.toString());
        couchBaseService.add(couchDocument);
    }

    public void updateUserStat(String userId, WebPageUserStat.WebPageUserStats webPageStats) throws TextFormat.ParseException {


        WebPageUserStat.WebPageUserStats.Builder builder = WebPageUserStat.WebPageUserStats.newBuilder();
        String data = (String)couchBaseService.get("WEBVIEW-"+"USERSTAT-"+userId+"-"+webPageStats.getCompleteUrl());
        if(data!=null){
            TextFormat.getParser().merge(data,builder);
            WebPageUserStat.WebPageUserStats prevStat =  builder.build();
            if(prevStat!=null){
                int likeCounter = 0;
                if(prevStat.getLike() && !webPageStats.getLike())
                    likeCounter--;
                if(!prevStat.getLike() && webPageStats.getLike())
                    likeCounter++;
                updateWebPageStat(webPageStats.getCompleteUrl(),likeCounter,webPageStats);
            }
        }else{
            int likeCounter = webPageStats.getLike()?1:0;
            updateWebPageStat(webPageStats.getCompleteUrl(),likeCounter,webPageStats);
        }

        CouchDocument couchDocument = new CouchDocument<WebPageUserStat.WebPageUserStats>();
        couchDocument.setId("WEBVIEW-"+"USERSTAT-"+userId+"-"+webPageStats.getCompleteUrl());
        couchDocument.setDocument(webPageStats);
        couchBaseService.add(couchDocument);
    }

    public WebPageUserStat.WebPageUserStats getUserStatForWebpage(String userId, String webpage) throws TextFormat.ParseException {

        String data = (String)couchBaseService.get("WEBVIEW-"+"USERSTAT-"+userId+"-"+webpage);
        WebPageUserStat.WebPageUserStats.Builder builder = WebPageUserStat.WebPageUserStats.newBuilder();
        if(data!=null){
            TextFormat.getParser().merge(data,builder);
        }

        return builder.build();
    }

    public WebPageStat.WebPageStats getWebPageStat(String webpage) throws TextFormat.ParseException {

        String data = (String)couchBaseService.get("WEBVIEW-"+"WEBPAGESTAT-"+webpage);
        WebPageStat.WebPageStats.Builder builder = WebPageStat.WebPageStats.newBuilder();
        if(data!=null){
            TextFormat.getParser().merge(data,builder);
        }
        return builder.build();
    }

    public void updateWebPageStat(String webpage,int likeCounter,WebPageUserStat.WebPageUserStats webPageUserStats) throws TextFormat.ParseException {
        WebPageStat.WebPageStats.Builder builder = WebPageStat.WebPageStats.newBuilder();
        String data= (String)couchBaseService.get("WEBVIEW-"+"WEBPAGESTAT-"+webpage);
        WebPageStat.WebPageStats newWebStat = null;
        if(data!=null){
            TextFormat.getParser().
                    merge((String)couchBaseService.get("WEBVIEW-"+"WEBPAGESTAT-"+webpage),builder) ;
            WebPageStat.WebPageStats prevWebStat = builder.build();
            newWebStat = WebPageStat.WebPageStats.newBuilder()
                    .setBaseUrl(prevWebStat.getBaseUrl()).setCompleteUrl(prevWebStat.getCompleteUrl())
                    .setHeader(prevWebStat.getHeader()).setLikes(prevWebStat.getLikes()+likeCounter).addAllMetadata(prevWebStat.getMetadataList())
                    .addAllTag(prevWebStat.getTagList()).build();

        }else{
            final WebPageStat.WebPageStats.Builder build  = WebPageStat.WebPageStats.newBuilder()
                    .setBaseUrl(webPageUserStats.getBaseUrl()).setCompleteUrl(webPageUserStats.getCompleteUrl())
                    .setHeader(webPageUserStats.getHeader()).setLikes(webPageUserStats.getLike()?1:0).
                            addMetadata(WebPageStat.WebPageStats.MetaData.newBuilder().setMetaData("hi"))
                    ;

            webPageUserStats.getTagList().stream().forEach(a->{
                build.addTag(WebPageStat.WebPageStats.Tags.newBuilder().setTag(a.getTag()));
            });
            newWebStat = build.build();
        }
        addWebPageStat(newWebStat);


    }

    public long getUserStat(String userId){
        return websterService.countUserEntry(userId);
    }
}
