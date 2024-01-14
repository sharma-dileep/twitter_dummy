package com.twitter.basic.service.impl;

import com.twitter.basic.dtos.requests.MessageAddRequest;
import com.twitter.basic.dtos.requests.MessageEditRequest;
import com.twitter.basic.model.Message;
import com.twitter.basic.model.UserModel;
import com.twitter.basic.repository.MessageRepository;
import com.twitter.basic.repository.UserRepository;
import com.twitter.basic.service.MessageService;
import com.twitter.basic.utils.RequestMapper;
import com.twitter.basic.utils.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    RequestMapper requestMapper;
    @Autowired
    ResponseMapper responseMapper;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Object addMessage(MessageAddRequest messageAddRequest) {
        Message message = requestMapper.fromMessageAddRequestToMessage(messageAddRequest);
        messageRepository.save(message);
        return responseMapper.fromMessageToMessageResponse(message);
    }


    @Override
    public Object editMessage(MessageEditRequest messageEditRequest) {
        Message message = messageRepository.findById(messageEditRequest.getMessageId()).get();
        message.setMessageContent(messageEditRequest.getMessageContent());
        messageRepository.save(message);
        return responseMapper.fromMessageToMessageResponse(message);
    }

    @Override
    public Object likeOrDislikeMessage(Long messageId, Long likerId) {
        // to be saved messagerepository
        if (userRepository.findById(likerId).isEmpty())
            return "User not exists login before you like";

        UserModel userModel = userRepository.findById(likerId).get();
        Message message = messageRepository.findById(messageId).get();
        Set<UserModel> likes = message.getLikedByUserModels();
        System.out.println(likes);
        if (likes.contains(userModel))
            likes.remove(userModel);
        else {
            likes.add(userModel);
            message.setLikedByUserModels(likes);

        }
        messageRepository.save(message);
        return responseMapper.fromMessageToMessageResponse(message);


    }


}
