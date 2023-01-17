package com.run2biz.run2bizchallengeapi.auth.dtos;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
}
