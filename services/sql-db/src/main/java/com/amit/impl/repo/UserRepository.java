package com.amit.impl.repo;

import com.amit.impl.entity.Users;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by amit on 2/6/16.
 */
@Repository
public interface UserRepository extends CrudRepository<Users,String> {

        public Users findByEmailId(String email);

}
