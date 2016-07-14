package com.amit.impl.repo;

import com.amit.impl.entity.TestItKit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by amit on 5/7/16.
 */
@Repository
public interface TestItKitRepository extends CrudRepository<TestItKit,String> {
}
