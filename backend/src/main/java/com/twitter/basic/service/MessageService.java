package com.twitter.basic.service;

import com.twitter.basic.dtos.requests.MessageAddRequest;

public interface MessageService {
    Object addMessage(MessageAddRequest messageAddRequest);
}
