package com.run2biz.run2bizchallengeapi.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("run2biz-challenge")
public class Run2bizChallengeProperties {
    private String jwtSecretKey;
}
