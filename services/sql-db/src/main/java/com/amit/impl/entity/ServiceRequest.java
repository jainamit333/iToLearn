package com.amit.impl.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by amit on 13/7/16.
 */
@Entity
@Table(name = "service_request")
@Data
public class ServiceRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    private String lob;

    @Column(name = "request_type")
    private String requestType;

    @Column
    private String code;

    @JoinColumn(name = "service_manager_id")
    @ManyToOne
    private ServiceManager serviceManager;


}
