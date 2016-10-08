package com.amit.tastekit;

import lombok.Data;

/**
 * Created by amit on 5/7/16.
 */
@Data
public class Tastekit {

    int user;
    int item;
    String status;

    @Override
    public String toString() {
        return "Tastekit{" +
                "user=" + user +
                ", item=" + item +
                ", status='" + status + '\'' +
                '}';
    }
}
