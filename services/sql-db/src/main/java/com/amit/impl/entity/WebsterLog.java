package com.amit.impl.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by amit on 28/6/16.
 */
@Entity
@Data
public class WebsterLog {

    @javax.persistence.Id
    @GeneratedValue
    private int Id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "web_page")
    private String webpage;

    @Column(name = "key")
    private String key;

}
