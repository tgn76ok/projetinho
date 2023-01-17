package com.run2biz.run2bizchallengeapi.users.mappers;

import com.run2biz.run2bizchallengeapi.users.dtos.UserDto;
import com.run2biz.run2bizchallengeapi.users.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    public User userDtoToUserEntity(UserDto userDto) {
        return new User(userDto.getName(), userDto.getCpf(), userDto.getEmail(), null);
    }

    @Override
    public UserDto userEntityToUserDto(User user) {
        return UserDto
                .builder()
                .id(user.getId())
                .name(user.getName())
                .cpf(user.getCpf())
                .email(user.getEmail())
                .build();
    }
}
