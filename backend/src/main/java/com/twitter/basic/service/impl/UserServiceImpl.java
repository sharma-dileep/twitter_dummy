package com.twitter.basic.service.impl;

import com.twitter.basic.dtos.requests.UserAddRequest;
import com.twitter.basic.dtos.responses.MessageResponse;
import com.twitter.basic.exceptions.UserAvailableException;
import com.twitter.basic.model.Message;
import com.twitter.basic.model.UserModel;
import com.twitter.basic.repository.UserRepository;
import com.twitter.basic.service.UserService;
import com.twitter.basic.utils.RequestMapper;
import com.twitter.basic.utils.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RequestMapper requestMapper;
    @Autowired
    private ResponseMapper responseMapper;

    @Override
    public Object addUser(UserAddRequest userAddRequest) {
        if(userAddRequest.getIsNewUser() && userRepository.findByName(userAddRequest.getUserName())!=null)
            return new UserAvailableException();
        UserModel userModel = requestMapper.fromUserAddRequestToUser(userAddRequest);
        userModel.setName(userAddRequest.getUserName());
        userRepository.save(userModel);
        return responseMapper.fromUserToUserAddResponse(userModel);
    }

    @Override
    public Object messagesLikedByMe(Long userId) {
        return (userRepository.findById(userId).get().getMessageSetLikedByMe());
    }

    @Override
    public Object getALlMessages(Long userId) {
        Set<MessageResponse> messageResponseSet = new HashSet<>();
        Set<Message> messageSet = userRepository.findById(userId).get().getMessageSet();
        for (Message message : messageSet)
            messageResponseSet.add(responseMapper.fromMessageToMessageResponse(message));

        return messageResponseSet;
    }
}
