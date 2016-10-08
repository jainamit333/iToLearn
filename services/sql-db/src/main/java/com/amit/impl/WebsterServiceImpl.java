package com.amit.impl;

import com.amit.impl.entity.WebsterLog;
import com.amit.impl.repo.WebsterRepository;
import com.amit.service.WebsterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by amit on 28/6/16.
 */
@Component
public class WebsterServiceImpl implements WebsterService {

    @Autowired
    WebsterRepository websterRepository;

    @Override
    public void add(WebsterLog websterLog) {
        websterRepository.save(websterLog);
    }

    @Override
    public List<WebsterLog> getUserEntry(String userId) {
        return websterRepository.findByUserId(userId);
    }

    @Override
    public long countUserEntry(String userId) {
        return websterRepository.countByUserId(userId);
    }

    @Override
    public long countWebPageEntry(String webpage) {
        return websterRepository.countByWebpage(webpage);
    }
}
