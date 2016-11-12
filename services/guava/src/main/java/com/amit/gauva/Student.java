package com.amit.gauva;

import lombok.Builder;
import lombok.Data;

/**
 * Created by amit on 10/10/16.
 */
@Data
@Builder
public class Student {

    String firstName;
    String LastName;
    int age;
}
