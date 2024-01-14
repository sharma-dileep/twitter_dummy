package com.twitter.basic.service;

import com.twitter.basic.dtos.requests.UserAddRequest;
import com.twitter.basic.dtos.responses.UserResponse;

public interface UserService {
    UserResponse addUser(UserAddRequest userAddRequest);

    Object messagesLikedByMe(Long userId);

}
