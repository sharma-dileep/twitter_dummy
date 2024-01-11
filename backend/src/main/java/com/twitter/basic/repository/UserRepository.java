package com.twitter.basic.repository;

import com.twitter.basic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUserId(Long id);

}
