package com.twitter.basic.repository;

import com.twitter.basic.model.Message;
import com.twitter.basic.model.User;
import com.twitter.basic.service.MessageService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Long> {

    public List<Message> findAllByUser(User user);
    

}
