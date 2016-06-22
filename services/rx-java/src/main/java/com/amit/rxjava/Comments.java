package com.amit.rxjava;

import lombok.Data;
import rx.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit on 22/6/16.
 */
@Data
public class Comments {


    private List<String> comment= new ArrayList<>();

    public Comments(String id) {
        Observable.range(0,4).subscribe(e->{
            comment.add(e.toString());
        });
    }
}
