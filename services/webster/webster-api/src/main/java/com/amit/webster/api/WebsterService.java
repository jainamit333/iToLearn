package com.amit.webster.api;

/**
 * Created by amit on 24/6/16.
 */
public interface WebsterService {

    void addUserStat(String userId, WebPageUserStat.WebPageUserStats webPageStats);
    void addWebPageStat(WebPageStat.WebPageStats webPageStats);
    void updateUserStat(String userId, WebPageUserStat.WebPageUserStats webPageStats);
    WebPageUserStat.WebPageUserStats getUserStatForWebpage(String userId, String webpage);
    WebPageStat.WebPageStats getWebPageStat(String webpage);

}
