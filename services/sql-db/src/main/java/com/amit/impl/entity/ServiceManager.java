package com.amit.impl.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by amit on 13/7/16.
 */
@Entity
@Data
@Table(name = "service_manager")
public class ServiceManager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "service_manager_name")
    private String serviceManagerName;

    @OneToMany(mappedBy = "serviceManager",cascade = CascadeType.ALL)
    private Set<ServiceBox> serviceBox;

}
