package com.run2biz.run2bizchallengeapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class IndexResource {
    @GetMapping
    public String index() {
        return "Server is running!";
    }
}
