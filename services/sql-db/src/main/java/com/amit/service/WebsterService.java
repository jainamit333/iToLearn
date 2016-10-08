package com.amit.service;

import com.amit.impl.entity.WebsterLog;

import java.util.List;

/**
 * Created by amit on 28/6/16.
 */
public interface WebsterService {

    void add(WebsterLog websterLog);
    List<WebsterLog> getUserEntry(String userId);
    long countUserEntry(String userId);
    long countWebPageEntry(String webpage);

}
