package com.amit.rxjava;

import lombok.Data;

/**
 * Created by amit on 22/6/16.
 */
@Data
public class EntityStat {

    private int likes;
    private int followed;
    private int comments;
    private int shared;

    public EntityStat(int likes,int followed, int shared, int comments){
        this.likes = likes;
        this.comments = comments;
        this.followed = followed;
        this.shared = shared;
    }


}
