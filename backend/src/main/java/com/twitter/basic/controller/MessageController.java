package com.twitter.basic.controller;


import com.twitter.basic.dtos.requests.MessageAddRequest;
import com.twitter.basic.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    public ResponseEntity addMessage(@RequestBody MessageAddRequest messageAddRequest){
    return ResponseEntity.ok(messageService.addMessage(messageAddRequest));
    }
}
