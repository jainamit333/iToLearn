package com.amit.impl.entity;


import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by amit on 2/6/16.
 */
@Entity
@Table(name = "user")
@Data
public class Users implements Serializable{

    @Id
    @GeneratedValue
    public Integer id;

    @Column(name = "user_name")
    public String userName;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "middle_name")
    public String middleName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "email_id")
    public String emailId;

    @Column(name = "phone_number")
    public String phoneNumber;


}
