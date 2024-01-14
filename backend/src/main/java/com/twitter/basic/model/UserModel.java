package com.twitter.basic.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "userModel")
    private Set<Message> messageSet;

    @ManyToMany(mappedBy = "likedByUserModels",fetch = FetchType.EAGER)
    private Set<Message> likedByUsers;
}
