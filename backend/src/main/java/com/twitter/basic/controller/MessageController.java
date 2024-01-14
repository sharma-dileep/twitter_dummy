package com.twitter.basic.controller;


import com.twitter.basic.constant.Url;
import com.twitter.basic.dtos.requests.MessageAddRequest;
import com.twitter.basic.dtos.requests.MessageEditRequest;
import com.twitter.basic.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;


    @PostMapping(Url.ADD_MESSAGE)
    public ResponseEntity<Object> addMessage(@RequestBody MessageAddRequest messageAddRequest) {
        return ResponseEntity.ok(messageService.addMessage(messageAddRequest));
    }

    @PatchMapping(Url.LIKE_OR_DISLIKE_MESSAGE)
    public ResponseEntity<Object> likeOrDislikeMessage(
            @RequestParam(name = "message_id") Long messageId,
            @RequestParam(name = "liker_id") Long likerId
    ) {

        return ResponseEntity.ok(messageService.likeOrDislikeMessage(messageId, likerId));

    }

    @PatchMapping(Url.EDIT_MESSAGE)
    public ResponseEntity<Object> editMessage(
            @RequestBody MessageEditRequest messageEditRequest
    ) {

        return ResponseEntity.ok(messageService.editMessage(messageEditRequest));

    }


}
