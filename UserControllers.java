package com.careerdevs.gorestv1.Controllers;

import com.careerdevs.gorestv1.Models.UserModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class UserControllers {

    @GetMapping()
    public Object getAll(RestTemplate restTemplate){
        try{
            String url = "" + ;

            ResponseEntity<UserModel[]> response = restTemplate.getForEntity(url, UserModel[].class);

            UserModel[] firstPageUsers = response.getBody();

            HttpHeaders responseHeaders = response.getHeaders();
            String totalPages = Objects.requireNonNull(responseHeaders.get("X-Pagination-Pages")).get(0);
            int totalPageNum = Integer.parseInt(totalPages);

            for (int i = 0; i < totalPageNum; i++) {

            }
            System.out.println("Total Pages: " + totalPages);

            return new ResponseEntity<>(firstPageUsers, HttpStatus.OK);


        }


    }

}
