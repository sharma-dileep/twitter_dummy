package com.twitter.basic.dtos.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAddRequest {
    private String userName;
}
