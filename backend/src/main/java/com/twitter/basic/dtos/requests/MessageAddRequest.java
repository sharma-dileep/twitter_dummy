package com.twitter.basic.dtos.requests;


import lombok.Data;

import java.sql.Date;
import java.time.ZonedDateTime;

@Data
public class MessageAddRequest {

    private String messageContent;
    private Long userId;
    private ZonedDateTime createdAt;

}
