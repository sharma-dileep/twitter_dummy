package com.twitter.basic.dtos.responses;

import com.twitter.basic.model.UserModel;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.Set;


@Builder
@Data
public class MessageResponse
{

        private String messageDescription;
        private  String userName;
        private ZonedDateTime createdAt;
        private Long messageId;
        private Set<UserModel> userModelLiked;



}
