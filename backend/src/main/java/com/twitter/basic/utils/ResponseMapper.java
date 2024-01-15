package com.twitter.basic.utils;


import com.twitter.basic.dtos.responses.MessageResponse;
import com.twitter.basic.dtos.responses.UserResponse;
import com.twitter.basic.model.Message;
import com.twitter.basic.model.UserModel;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ResponseMapper {


    public UserResponse fromUserToUserAddResponse(UserModel userModel){
        return UserResponse.builder()
                .userId(userModel.getId())
                .userName(userModel.getName())
                .messageSet(userModel.getMessageSet()).build();
    }

    public MessageResponse fromMessageToMessageResponse(Message message){
        return MessageResponse.builder().
                messageDescription(message.getMessageContent()).
                userName(message.getUserModel().getName()).
                userModelLiked(message.getLikedByUserModels()).
                createdAt(message.getCreatedOn()).build();
    }



}
