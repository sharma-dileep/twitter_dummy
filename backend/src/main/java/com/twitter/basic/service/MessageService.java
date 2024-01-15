package com.twitter.basic.service;

import com.twitter.basic.dtos.requests.MessageAddRequest;
import com.twitter.basic.dtos.requests.MessageEditRequest;

public interface MessageService {
    Object addMessage(MessageAddRequest messageAddRequest);
    Object editMessage(MessageEditRequest messageEditRequest);

    Object likeOrDislikeMessage(Long messageId, Long likerId);

    Object getAllMessages();

    Object deleteMessage(Long messageId);
}
