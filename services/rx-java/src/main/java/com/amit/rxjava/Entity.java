package com.amit.rxjava;

import lombok.Data;

/**
 * Created by amit on 22/6/16.
 */
@Data
public class Entity{

    private String id;
    private String name;
    private String picId;
    private String ownerId;
    private UserStat userStat;
    private EntityStat entityStat;
    private Tags tags;
    private Comments comment;
    private User owner;

    public Entity(String id,String name,String ownerId,String picId){
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.picId = picId;

    }

    public Entity() {
    }

    public Entity(User e) {

    }

    public Entity(Entity entity) {
            this.id =entity.id;
            this.name = entity.name;
        this.picId = entity.picId;
        this.ownerId = entity.ownerId;
        this.userStat = entity.userStat;
        this.entityStat = entity.entityStat;
        this.tags = entity.tags;
        this.comment = entity.comment;
        this.owner = entity.owner;
    }
}
