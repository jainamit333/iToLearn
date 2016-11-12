package com.amit.gauva;

import com.google.common.base.Preconditions;

/**
 * Created by amit on 10/10/16.
 */
public class PreconditionTest {

    public double suareRoot(Double intput){

        Preconditions.checkNotNull(intput);
        Preconditions.checkArgument(intput>0.0);
        return Math.sqrt(intput);
    }
}
