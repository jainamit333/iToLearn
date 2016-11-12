package com.amit.gauva;

import com.google.common.base.Objects;
import com.google.common.base.Throwables;
import com.google.common.collect.Range;

/**
 * Created by amit on 10/10/16.
 */
public class ObjectsTest {

    public void test(){

        Student s1 = Student.builder().firstName("firstName").LastName("lastName").age(12).build();
        Student s2 = Student.builder().firstName("firstName1").LastName("lastName1").age(22).build();

        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(Objects.equal(null,null));
        System.out.println(Objects.equal(s1,s1));

    }

    public void testRange(){
        System.out.println(Range.all());
        System.out.println(Range.atLeast(2));
        System.out.println(Range.atLeast(2).contains(0));
        System.out.println(Range.closed(1,8));
        System.out.println(Range.closed(1,8).contains(3));
        System.out.println(Range.singleton(3));
    }

    public void throwable(){

        try{
            int a =2;
            int b = 0;
            int c = a/b;

        }catch (Exception e){
            System.out.println(Throwables.getCausalChain(e));
            System.out.println(Throwables.getRootCause(e));
            System.out.println(Throwables.getStackTraceAsString(e));
            System.out.println(Throwables.lazyStackTrace(e));
            Throwables.propagateIfInstanceOf(e,NullPointerException.class);
            Throwables.propagate(e);
        }

        System.out.println(Throwables.getCausalChain(new Throwable("help")));;
        System.out.println(Throwables.getRootCause(new Throwable("root cause")));

        Throwables.propagateIfInstanceOf(new RuntimeException(),NullPointerException.class);
        System.out.println("propogated");
    }
}
