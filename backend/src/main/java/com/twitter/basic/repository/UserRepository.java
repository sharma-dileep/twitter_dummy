package com.twitter.basic.repository;

import com.twitter.basic.model.Message;
import com.twitter.basic.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Long> {




}
