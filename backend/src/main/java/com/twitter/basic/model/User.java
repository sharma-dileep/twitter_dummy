package com.twitter.basic.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;

    @OneToMany(mappedBy = "user")
    private Set<Message> messageSet;

    @ManyToMany(mappedBy = "likedByUsers")
    private Set<Message> likedByUsed;
}
