package com.run2biz.run2bizchallengeapi.users.mappers;

import com.run2biz.run2bizchallengeapi.users.dtos.UserDto;
import com.run2biz.run2bizchallengeapi.users.entities.User;

public interface UserMapper {
    User userDtoToUserEntity(UserDto userDto);
    UserDto userEntityToUserDto(User user);
}
