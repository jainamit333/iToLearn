package com.amit.couch.impl;

import com.amit.couch.api.CouchDocument;
import com.amit.couch.api.CouchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by amit on 23/6/16.
 */
@Component
public class CouchServiceImpl implements CouchService<CouchDocument> {

    @Autowired
    CouchRepository couchRepository;

    public void add(CouchDocument o) {
        couchRepository.save(o);
    }


    public CouchDocument get(String key) {
        return couchRepository.findOne(key);
    }


    public void delete(String key) {
        couchRepository.delete(key);
    }

}
