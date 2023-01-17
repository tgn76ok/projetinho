package com.run2biz.run2bizchallengeapi.auth.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUsername(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    String generateToken(UserDetails userDetails);
}
