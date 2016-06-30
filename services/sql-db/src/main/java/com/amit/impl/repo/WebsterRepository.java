package com.amit.impl.repo;

import com.amit.impl.entity.Users;
import com.amit.impl.entity.WebsterLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by amit on 28/6/16.
 */
@Repository
public interface WebsterRepository extends CrudRepository<WebsterLog,String> {

    List<WebsterLog> findByUserId(String userId);

    long countByUserId(String userId);

    long countByWebpage(String webpage);
}
