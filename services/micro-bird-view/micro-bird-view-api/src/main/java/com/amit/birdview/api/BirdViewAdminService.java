package com.amit.birdview.api;

import com.amit.birdview.impl.pojo.Server;

import java.util.List;

/**
 * Created by amit on 23/6/16.
 */
public interface BirdViewAdminService {

    void addNewServer(String name,String group,String ipAddress,Boolean isActive);
    List<Server> getAllServers();
    Server getServer(String id);


}
