package com.twitter.basic.utils;


import com.twitter.basic.dtos.requests.UserAddRequest;
import com.twitter.basic.dtos.responses.MessageResponse;
import com.twitter.basic.dtos.responses.UserResponse;
import com.twitter.basic.model.Message;
import com.twitter.basic.model.User;
import org.springframework.stereotype.Component;

@Component
public class ResponseMapper {


    public UserResponse fromUserToUserAddResponse(User user){
        return UserResponse.builder().userId(user.getId()).userName(user.getUserName()).messageSet(user.getMessageSet()).build();
    }

    public MessageResponse fromMessageToMessageResponse(Message message){
        return MessageResponse.builder().messageDescription(message.getMessageContent()).userName(message.getUser().getUserName()).userLiked(
                message.getLikedByUsers()
        ).build();
    }



}
