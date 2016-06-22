package com.amit.rxjava;

import rx.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit on 22/6/16.
 */
public class Tags {

    private List<String> tags= new ArrayList<>();

    public Tags(String id) {
        Observable.range(0,5).subscribe(e->{
           tags.add(e.toString());
        });
    }
}
