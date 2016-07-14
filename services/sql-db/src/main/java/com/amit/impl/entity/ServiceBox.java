package com.amit.impl.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by amit on 13/7/16.
 */
@Entity
@Data
@Table(name = "service_box")
public class ServiceBox {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "service_box_name")
    private String serviceBoxName;

    @Column(name = "execution_sequence")
    private Integer executionSequence;

    @OneToMany(mappedBy = "serviceBox",cascade = CascadeType.ALL)
    private Set<Service> services;

    @JoinColumn(name = "service_manager_id")
    @ManyToOne
    private ServiceManager serviceManager;


}
