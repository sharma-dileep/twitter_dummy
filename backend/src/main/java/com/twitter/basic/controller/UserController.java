package com.twitter.basic.controller;


import com.twitter.basic.constant.Url;
import com.twitter.basic.dtos.requests.UserAddRequest;
import com.twitter.basic.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private UserService userService;
    @PutMapping(value = Url.ADD_USER)
    public ResponseEntity<Object> addUser(@Valid @RequestBody UserAddRequest userAddRequest){
        return ResponseEntity.ok(userService.addUser(userAddRequest));
    }
}
