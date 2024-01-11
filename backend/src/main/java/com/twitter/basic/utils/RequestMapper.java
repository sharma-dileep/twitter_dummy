package com.twitter.basic.utils;

import com.twitter.basic.dtos.requests.MessageAddRequest;
import com.twitter.basic.dtos.requests.UserAddRequest;
import com.twitter.basic.model.Message;
import com.twitter.basic.model.User;
import com.twitter.basic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RequestMapper {


    @Autowired
    private UserRepository userRepository;
    public User fromUserAddRequestToUser(UserAddRequest userAddRequest){
        return User.builder().userName(userAddRequest.getUserName()).build();
    }

    public Message fromMessageAddRequestToMessage(MessageAddRequest messageAddRequest){
        return Message.builder().messageContent(messageAddRequest.getMessageContent()).user(userRepository.findByUserId(messageAddRequest.getUserId())).build();
    }

}
