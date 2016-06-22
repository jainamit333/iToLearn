package com.amit.rxjava;

import lombok.Data;

/**
 * Created by amit on 22/6/16.
 */
@Data
public class User {

    private String id;
    private String name;

    public User(String id, String s) {
        this.id = id;
        this.name = s;
    }
}
