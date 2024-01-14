package com.twitter.basic.controller;


import com.twitter.basic.constant.Url;
import com.twitter.basic.dtos.requests.UserAddRequest;
import com.twitter.basic.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController{


    @Autowired
    private UserService userService;
    @PostMapping(Url.ADD_USER)
    public ResponseEntity<Object> addUser( @RequestBody UserAddRequest userAddRequest){
        return ResponseEntity.ok(userService.addUser(userAddRequest));
    }

    @GetMapping(Url.GET_USER)
    public ResponseEntity<Object> getUser( @RequestParam(name = "user_id") Long userId){
        return ResponseEntity.ok(userService.messagesLikedByMe(userId));
    }
}
