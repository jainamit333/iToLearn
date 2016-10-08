package com.amit.impl.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by amit on 29/6/16.
 */
@Entity
@Table
@Data
public class Account {


    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private  String firstName;

    @Column(nullable = false)
    private String lastName;



}
