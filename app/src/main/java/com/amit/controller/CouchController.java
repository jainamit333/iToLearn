package com.amit.controller;

import com.amit.couch.api.CouchDocument;
import com.amit.couch.api.CouchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by amit on 6/7/16.
 */
@RestController
@RequestMapping(value = "/couch")
public class CouchController {

    @Autowired
    CouchService couchService;

    @RequestMapping(value = "fill")
    public String fillData(){

        for(int i =0;i<100;i++){
            CouchDocument couchDocument = new CouchDocument();
            couchDocument.setDocument("I am original Document");
            if(i <20)
                couchDocument.setReferenceId(1);
            if(i>=20 && i <80 )
                couchDocument.setReferenceId(2);
            if(i >=80)
                couchDocument.setReferenceId(3);
            couchService.add(couchDocument);
        }

        return "done";
    }

    @RequestMapping(value = "get")
    public String getByDocumentParam(){
        return couchService.getFromDocument(1).toString();
    }

    @RequestMapping(value = "delete")
    public String deleteByDocumentParam(){
         couchService.deleteFromDocument(1);
        return "DONE";
    }

}
