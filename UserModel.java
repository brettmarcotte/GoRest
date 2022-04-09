package com.careerdevs.gorestv1.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {

    public UserModel() {
    }

    public UserModel(String name, String email, String gender, String status){
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }

    private int id;
    @JsonProperty ("post_id")
    private String name;
    private String email;
    private String gender;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String generateReport (){
        return name + " is current " + status + " You can contact them at: " + email;
    }

    @Override
    public String toString() {
        return null;
    }



}
