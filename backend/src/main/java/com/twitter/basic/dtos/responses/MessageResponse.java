package com.twitter.basic.dtos.responses;

import com.twitter.basic.model.Message;
import com.twitter.basic.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.Set;


@Builder
@Data
public class MessageResponse
{

        private String messageDescription;
        private  String userName;
        private Set<User> userLiked;



}
