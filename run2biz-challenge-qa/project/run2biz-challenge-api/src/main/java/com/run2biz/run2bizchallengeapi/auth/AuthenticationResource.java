package com.run2biz.run2bizchallengeapi.auth;

import com.run2biz.run2bizchallengeapi.auth.dtos.AuthDto;
import com.run2biz.run2bizchallengeapi.auth.dtos.LoginDto;
import com.run2biz.run2bizchallengeapi.auth.services.AuthenticateService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/auth")
public class AuthenticationResource {
    private final AuthenticateService authenticateService;

    public AuthenticationResource(AuthenticateService authenticateService) {
        this.authenticateService = authenticateService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public AuthDto create(@RequestBody LoginDto login) {
        return authenticateService.create(login);
    }
}
