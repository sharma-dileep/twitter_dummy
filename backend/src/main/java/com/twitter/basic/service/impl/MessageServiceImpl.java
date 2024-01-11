package com.twitter.basic.service.impl;

import com.twitter.basic.dtos.requests.MessageAddRequest;
import com.twitter.basic.model.Message;
import com.twitter.basic.repository.MessageRepository;
import com.twitter.basic.service.MessageService;
import com.twitter.basic.utils.RequestMapper;
import com.twitter.basic.utils.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageServiceImpl implements MessageService {

    @Autowired
    RequestMapper requestMapper;

    @Autowired
    ResponseMapper responseMapper;

    @Autowired
    MessageRepository messageRepository;

    @Override
    public Object addMessage(MessageAddRequest messageAddRequest) {
        Message message = requestMapper.fromMessageAddRequestToMessage(messageAddRequest);
        messageRepository.save(message);
        return responseMapper.fromMessageToMessageResponse(message);
    }
}
