package com.amit.couch.impl;

import com.amit.couch.api.CouchDocument;
import com.amit.couch.api.CouchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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


    public Object get(String key) {
        CouchDocument couchDocument =  couchRepository.findOne(key);
        if(couchDocument!=null){
            return couchRepository.findOne(key).getDocument();
        }
        return null;
    }


    public void delete(String key) {
        couchRepository.delete(key);
    }

    public List<CouchDocument> getFromDocument(int i){
        return couchRepository.findByReferenceId(i);
    }
    public void deleteFromDocument(int i){
        couchRepository.deleteByReferenceId(i);
    }

}
