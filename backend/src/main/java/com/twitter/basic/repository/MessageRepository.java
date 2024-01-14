package com.twitter.basic.repository;

import com.twitter.basic.model.Message;
import com.twitter.basic.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {

    public List<Message> findAllByUserModel(UserModel userModel);
    

}
