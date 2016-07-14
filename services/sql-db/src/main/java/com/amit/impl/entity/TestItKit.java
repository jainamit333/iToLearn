package com.amit.impl.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by amit on 5/7/16.
 */
@Entity
@Data
public class TestItKit {

    @Id
    @GeneratedValue
    private int id;
    @Column
    Integer user;

    @Column
    int item;

    @Column
    String status;
}
