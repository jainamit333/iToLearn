package com.amit.couch.impl;

import com.amit.couch.api.CouchDocument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by amit on 24/6/16.
 */
@Repository
public interface CouchRepository extends CrudRepository<CouchDocument,String> {

    List<CouchDocument> findByReferenceId(int i);

    void deleteByReferenceId(int i);
}
