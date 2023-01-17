package com.run2biz.run2bizchallengeapi.config.validation;

import lombok.Getter;

@Getter
public class DuplicatedItemException extends RuntimeException {
    private final String field;

    public DuplicatedItemException(String field, String message) {
        super(message);
        this.field = field;
    }
}
