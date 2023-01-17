package com.run2biz.run2bizchallengeapi.auth.services;

import com.run2biz.run2bizchallengeapi.auth.dtos.AuthDto;
import com.run2biz.run2bizchallengeapi.auth.dtos.LoginDto;
import com.run2biz.run2bizchallengeapi.users.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateServiceimpl implements AuthenticateService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthenticateServiceimpl(AuthenticationManager authenticationManager,
                                   UserRepository userRepository, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public AuthDto create(LoginDto loginDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
        );

        var user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);

        return AuthDto.builder().token(jwtToken).build();
    }
}
