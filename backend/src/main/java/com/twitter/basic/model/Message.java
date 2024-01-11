package com.twitter.basic.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String messageContent;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;


    @ManyToMany
    @JoinTable(
            name = "user_liked",
            joinColumns = { @JoinColumn(name = "message_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private Set<User> likedByUsers;


}
