package com.run2biz.run2bizchallengeapi.users.services;

import com.run2biz.run2bizchallengeapi.config.validation.DuplicatedItemException;
import com.run2biz.run2bizchallengeapi.users.UserRepository;
import com.run2biz.run2bizchallengeapi.users.dtos.UserDto;
import com.run2biz.run2bizchallengeapi.users.entities.Role;
import com.run2biz.run2bizchallengeapi.users.entities.User;
import com.run2biz.run2bizchallengeapi.users.mappers.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto create(UserDto userToCreate) {
        Optional<User> duplicateduser = userRepository.findByEmail(userToCreate.getEmail());
        if (duplicateduser.isPresent()) {
            throw new DuplicatedItemException("email", "user already registered");
        }

        User user = userMapper.userDtoToUserEntity(userToCreate);
        user.setPassword(passwordEncoder.encode(userToCreate.getPassword()));
        user.setRole(Role.USER);

        return userMapper.userEntityToUserDto(userRepository.save(user));
    }
}
