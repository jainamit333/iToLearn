package com.amit.tastekit;

import com.amit.impl.entity.TestItKit;
import com.amit.impl.repo.TestItKitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by amit on 5/7/16.
 */
@Component
public class Testme {


    @Autowired
    private TestItKitRepository testItKitRepository;



    public void execute() {

        String url = "https://tastekit.api-docs.io/api/v1/likes/like?token=2a4e22dad83e7a58";
        RestTemplate restTemplate = new RestTemplate();

        int itemMin = 0;int itemMax = 10000;
        int userItemMin =90;int userItemMax = 120;

        for(int i = 0 ;i<100;i++){
            int useritems = userItemMin + (int)(Math.random() * userItemMax);
            for(int j = 0 ;j < useritems;j++){

                TestItKit tastekit = new TestItKit();

                Integer user = i;
                Integer item = itemMin + (int)(Math.random() * itemMax);
                tastekit.setItem(item);tastekit.setUser(user);
                MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
                List<String> ac = new ArrayList<String>();
                ac.add(Integer.toString(i));
                headers.put("user",ac);
                List<String> ace = new ArrayList<String>();
                ace.add(Integer.toString(item));
                headers.put("item",ace);
                HttpEntity<Tastekit> httpEntity = new HttpEntity<Tastekit>(headers);
                ResponseEntity<String> s = restTemplate.exchange(url, HttpMethod.POST,httpEntity,String.class);
                tastekit.setStatus(s.getStatusCode().toString());
                testItKitRepository.save(tastekit);

            }
        }




    }
}
