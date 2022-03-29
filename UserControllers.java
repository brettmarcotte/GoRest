package com.careerdevs.gorestv1.Controllers;

import com.careerdevs.gorestv1.Models.UserModel;
import com.careerdevs.gorestv1.Models.UserModelArray;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class UserControllers {

    @Autowired
    Environment env;

    //URL / endpoint http://localhost:444/api/users/token
    @GetMapping ("/token")
    public String getToken () {
        return env.getProperty("GOREST_TOKEN");
    }


    @GetMapping
    public Object getFirstPage (RestTemplate restTemplate) {

        try {
            String url = "https://gorest.co.in/public/v2/users";

            ResponseEntity<UserModel[]> firstPage = restTemplate.getForEntity(url, UserModel[].class);

            UserModel[] firstPageUsers =  firstPage.getBody();

            for (int i = 0; i < firstPageUsers.length; i++) {
                UserModel tempUser = firstPageUsers[i];

                System.out.println(tempUser.generateReport());

            }

            return firstPage;

        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
            return  new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping ("/{id}")
    public Object getOneUser (@PathVariable ("id") String userId, RestTemplate restTemplate) {
        try {
            String url = "http://gorest.co.in/public/v2/users/" + userId;

            return restTemplate.getForObject(url, Object.class);

        } catch (Exception exception) {
            return "404: No user exists with the ID " + userId;
        }
    }

    @DeleteMapping ("/{id}")
    public Object deleteOneUser (@PathVariable ("id") String userId, RestTemplate restTemplate) {
        try {
            String url = "http://gorest.co.in/public/v2/users/" + userId;
            restTemplate.delete(url);
            return "Successfully Deleted user #" + userId;
        } catch (Exception exception) {
            return "404: No user exists with the ID " + userId;
        }
    }





    @GetMapping()
    public Object getAll(RestTemplate restTemplate){
        try{
            String url = "" + "";

            ResponseEntity<UserModel[]> response = restTemplate.getForEntity(url, UserModel[].class);

            UserModel[] firstPageUsers = response.getBody();

            HttpHeaders responseHeaders = response.getHeaders();
            String totalPages = Objects.requireNonNull(responseHeaders.get("X-Pagination-Pages")).get(0);
            int totalPageNum = Integer.parseInt(totalPages);

            for (int i = 0; i < totalPageNum; i++) {

            }
            System.out.println("Total Pages: " + totalPages);

            return new ResponseEntity<>(firstPageUsers, HttpStatus.OK);


        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


        return null;
    }

}
