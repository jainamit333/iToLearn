package com.amit.impl.repo;

import com.amit.impl.entity.ServiceRequest;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by amit on 13/7/16.
 */
public interface ServiceRequestRepository extends CrudRepository<ServiceRequest,String> {


    ServiceRequest findOneByLobAndRequestTypeAndCode(String lob,String requestType,String code);
}
