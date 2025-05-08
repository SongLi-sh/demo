package com.scb.demo.controller;

import com.scb.demo.model.DemoUserEntity;
import com.scb.demo.model.DemoUserCreatedResponse;
import com.scb.demo.service.DemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.scb.demo.exception.UserNotFoundException
;


@RestController
public class DemoController {

    @Autowired
    private DemoUserService demoUserService;

    @GetMapping(value = "/api/v1/users/{id}")
    public ResponseEntity<DemoUserEntity> getUserdetailById(@PathVariable("id")  String id) throws UserNotFoundException {

        return new ResponseEntity(demoUserService.findUserById(id).orElseThrow( ()-> new UserNotFoundException("404","User Not Found")),HttpStatus.OK);
    }

    @GetMapping(value = "/api/v1/users")
    public ResponseEntity<DemoUserCreatedResponse> createUser(DemoUserEntity demoUserEntity) {
        String id = demoUserService.save(demoUserEntity);
        return new ResponseEntity<DemoUserCreatedResponse>(new DemoUserCreatedResponse(id), HttpStatus.CREATED);
    }




}
