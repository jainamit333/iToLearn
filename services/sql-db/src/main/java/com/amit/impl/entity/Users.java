package com.amit.impl.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by amit on 2/6/16.
 */
@Entity
@Table(name = "users")
@Data
public class Users implements Serializable{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "user_name")
    @PrimaryKeyJoinColumn
    private String userName;

    @Column
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "enabled")
    private Boolean enables;

}
