package com.amit.impl.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by amit on 28/6/16.
 */
@Entity
//@Table(name = "websterLog")
@Data
public class WebsterLog {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String userId;

    @Column
    private String webpage;

    @Column
    private String couchKey;

}
