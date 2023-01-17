package com.run2biz.run2bizchallengeapi.users;

import com.fasterxml.jackson.annotation.JsonView;
import com.run2biz.run2bizchallengeapi.users.dtos.UserDto;
import com.run2biz.run2bizchallengeapi.users.dtos.UserDtoView;
import com.run2biz.run2bizchallengeapi.users.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UsersResource {
    private final UserService userService;

    public UsersResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @JsonView(UserDtoView.Get.class)
    public UserDto create(@JsonView(UserDtoView.Create.class)
                          @Validated(UserDtoView.Create.class)
                          @RequestBody UserDto user) {
        return userService.create(user);
    }
}
