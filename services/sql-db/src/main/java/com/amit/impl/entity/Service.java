package com.amit.impl.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by amit on 13/7/16.
 */
@Entity
@Data
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "service_name")
    private String serviceName;


    @JoinColumn(name = "service_box_id")
    @ManyToOne
    private ServiceBox serviceBox;



}
