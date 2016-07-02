package com.amit.webster;

import com.google.protobuf.TextFormat;

/**
 * Created by amit on 24/6/16.
 */
public interface CoreWebsterService {

    void addUserStat(String userId, WebPageUserStat.WebPageUserStats webPageStats) throws TextFormat.ParseException;
    void addWebPageStat(WebPageStat.WebPageStats webPageStats);
    void updateUserStat(String userId, WebPageUserStat.WebPageUserStats webPageStats) throws TextFormat.ParseException;
    WebPageUserStat.WebPageUserStats getUserStatForWebpage(String userId, String webpage) throws TextFormat.ParseException;
    WebPageStat.WebPageStats getWebPageStat(String webpage) throws TextFormat.ParseException;
    long getUserStat(String userId);

}
