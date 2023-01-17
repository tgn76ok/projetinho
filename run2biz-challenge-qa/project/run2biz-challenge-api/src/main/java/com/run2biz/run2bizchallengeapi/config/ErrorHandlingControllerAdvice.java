package com.run2biz.run2bizchallengeapi.config;

import com.run2biz.run2bizchallengeapi.config.validation.DuplicatedItemException;
import com.run2biz.run2bizchallengeapi.config.validation.ValidationErrorResponse;
import com.run2biz.run2bizchallengeapi.config.validation.Violation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onConstraintValidationException(
            ConstraintViolationException e) {
        ValidationErrorResponse error = new ValidationErrorResponse();

        for (var violation : e.getConstraintViolations()) {
            error.getErrors().add(
                    new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
        }

        return error;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {
        ValidationErrorResponse error = new ValidationErrorResponse();

        for (var fieldError : e.getBindingResult().getFieldErrors()) {
            error.getErrors().add(
                    new Violation(fieldError.getField(), fieldError.getDefaultMessage())
            );
        }

        return error;
    }

    @ExceptionHandler(DuplicatedItemException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorResponse onDuplicatedItemException(DuplicatedItemException e) {
        ValidationErrorResponse error = new ValidationErrorResponse();
        error.getErrors().add(new Violation(e.getField(), e.getMessage()));
        return error;
    }
}
