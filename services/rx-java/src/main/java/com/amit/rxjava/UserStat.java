package com.amit.rxjava;

import lombok.Data;

/**
 * Created by amit on 22/6/16.
 */
@Data
public class UserStat {

    private boolean liked;
    private boolean follow;
    private boolean shared;

    public UserStat(boolean follow,boolean liked,boolean shared){
        this.follow = follow;
        this.liked = liked;
        this.shared = shared;
    }


}
