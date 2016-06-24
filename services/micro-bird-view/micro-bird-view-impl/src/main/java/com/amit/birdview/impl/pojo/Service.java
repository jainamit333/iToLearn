package com.amit.birdview.impl.pojo;

import lombok.Data;

/**
 * Created by amit on 23/6/16.
 */
@Data
public class Service {

    private String serverId;
    private String microServiceName;
    private String contextPath;
    private String httpHeader;
    private String scope;
    private boolean is_active;
}
