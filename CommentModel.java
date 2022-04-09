package com.careerdevs.gorestv1.Models;

public class CommentModel {


    public CommentModel(int post_id, String name, String email, String body){
        this.post_id = post_id;
        this.name = name;
        this.email = email;
        this.body = body;

    }

    private int id;

    private int post_id;
    private String name;
    private String email;
    private String body;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String generateReport (){
        return name + " is current " + body + " You can contact them at: " + email;
    }

    @Override
    public String toString() {
        return null;
    }



}
