package com.run2biz.run2bizchallengeapi.users.services;

import com.run2biz.run2bizchallengeapi.users.dtos.UserDto;

public interface UserService {
    UserDto create(UserDto userToCreate);
}
