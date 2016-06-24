package com.amit.birdview.impl;

import com.amit.birdview.api.BirdViewAdminService;
import com.amit.birdview.impl.pojo.Server;

import java.util.List;

/**
 * Created by amit on 23/6/16.
 */
public class BirdViewAdminServiceImpl implements BirdViewAdminService {


    public void addNewServer(String name,String group,String ipAddress,Boolean isActive) {
        Server.ServerS server = Server.ServerS.newBuilder().setName(name).setIpAddress(ipAddress).
                setGroup(group).setIsActive(isActive).build();
        //// TODO: 24/6/16 should use mongo

    }

    public List<Server> getAllServers() {
        return null;
    }

    public Server getServer(String id) {
        return null;
    }
}
