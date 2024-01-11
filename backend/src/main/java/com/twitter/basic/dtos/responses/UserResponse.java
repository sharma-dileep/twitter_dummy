package com.twitter.basic.dtos.responses;


import com.twitter.basic.model.Message;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class UserResponse {

    private Long userId;
    private  String userName;
    private Set<Message> messageSet;

}
