package com.twitter.basic.dtos.requests;


import lombok.Data;

@Data
public class MessageAddRequest {

    private String messageContent;
    private Long userId;

}
