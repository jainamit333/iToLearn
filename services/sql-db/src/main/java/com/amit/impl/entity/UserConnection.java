package com.amit.impl.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by amit on 19/6/16.
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"userId","providerId","providerUserId"}))
@Data
public class UserConnection {

    @Id
    @GeneratedValue
    private int id;


    @Column()
    private String userId;

    @Column()
    private String providerId;

    @Column()
    private String providerUserId;

    @Column
    private int rank;

    @Column()
    private String displayName;

    @Column()
    private String profileUrl;

    @Column()
    private String imageUrl;

    @Column()
    private String accessToken;

    @Column()
    private String secret;

    @Column()
    private String refreshToken;

    @Column()
    private long expireTime;



}
