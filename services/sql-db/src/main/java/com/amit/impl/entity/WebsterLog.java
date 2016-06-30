package com.amit.impl.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by amit on 28/6/16.
 */
@Entity
@Table
@Data
public class WebsterLog {

    @javax.persistence.Id
    private int Id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "web_page")
    private String webpage;

    @Column(name = "key")
    private String key;

}
