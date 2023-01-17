package com.run2biz.run2bizchallengeapi.auth.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthDto {
    private String token;
}
