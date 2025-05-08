package com.scb.demo.model;


import lombok.Data;

@Data
public class DemoUserCreatedResponse {

    public DemoUserCreatedResponse (String id){
        this.id = id;
    }
    String id;

}
