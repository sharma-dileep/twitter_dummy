package com.twitter.basic.service.impl;

import com.twitter.basic.dtos.requests.UserAddRequest;
import com.twitter.basic.dtos.responses.UserResponse;
import com.twitter.basic.model.User;
import com.twitter.basic.repository.UserRepository;
import com.twitter.basic.service.UserService;
import com.twitter.basic.utils.RequestMapper;
import com.twitter.basic.utils.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RequestMapper requestMapper;
    @Autowired
    private ResponseMapper responseMapper;
    @Override
    public UserResponse addUser(UserAddRequest userAddRequest) {
        User user = requestMapper.fromUserAddRequestToUser(userAddRequest);
        user.setUserName(userAddRequest.getUserName());
        userRepository.save(user);
        return responseMapper.fromUserToUserAddResponse(user);
    }
}
