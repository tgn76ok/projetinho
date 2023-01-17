package com.run2biz.run2bizchallengeapi.auth.services;

import com.run2biz.run2bizchallengeapi.auth.dtos.AuthDto;
import com.run2biz.run2bizchallengeapi.auth.dtos.LoginDto;

public interface AuthenticateService {
    AuthDto create(LoginDto loginDto);
}
