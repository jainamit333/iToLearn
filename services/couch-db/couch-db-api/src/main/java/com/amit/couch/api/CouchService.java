package com.amit.couch.api;

import java.util.Map;

/**
 * Created by amit on 23/6/16.
 */
public interface CouchService<CouchDocument> {

    void add(CouchDocument t);
    Object get(String key);
    void delete(String key);


}
