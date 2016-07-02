package com.amit.service.reimann;

import io.riemann.riemann.client.RiemannClient;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by amit on 30/6/16.
 */

public class ReimannRegistry {

    RiemannClient riemannClient;

    public ReimannRegistry(String host,int port) throws IOException{
        this.riemannClient = RiemannClient.tcp(host,port);
    }

    public RiemannClient getRiemannClient(){
        return this.riemannClient;
    }
}
