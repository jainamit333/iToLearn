package com.amit.webster;

/**
 * Created by amit on 24/6/16.
 */
public interface CoreWebsterService {

    void addUserStat(String userId, WebPageUserStat.WebPageUserStats webPageStats);
    void addWebPageStat(WebPageStat.WebPageStats webPageStats);
    void updateUserStat(String userId, WebPageUserStat.WebPageUserStats webPageStats);
    WebPageUserStat.WebPageUserStats getUserStatForWebpage(String userId, String webpage);
    WebPageStat.WebPageStats getWebPageStat(String webpage);
    long getUserStat(String userId);

}
