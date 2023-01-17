package com.run2biz.run2bizchallengeapi.config.validation;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationErrorResponse {
    private List<Violation> errors = new ArrayList<>();
}

