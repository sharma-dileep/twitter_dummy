package com.twitter.basic.service.impl;

import com.twitter.basic.dtos.requests.UserAddRequest;
import com.twitter.basic.dtos.responses.UserResponse;
import com.twitter.basic.model.UserModel;
import com.twitter.basic.repository.UserRepository;
import com.twitter.basic.service.UserService;
import com.twitter.basic.utils.RequestMapper;
import com.twitter.basic.utils.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RequestMapper requestMapper;
    @Autowired
    private ResponseMapper responseMapper;
    @Override
    public UserResponse addUser(UserAddRequest userAddRequest) {
        UserModel userModel = requestMapper.fromUserAddRequestToUser(userAddRequest);
        userModel.setName(userAddRequest.getUserName());
        userRepository.save(userModel);
        return responseMapper.fromUserToUserAddResponse(userModel);
    }

    @Override
    public Object messagesLikedByMe(Long userId) {
        return (userRepository.findById(userId).get().getLikedByUsers());
    }
}
