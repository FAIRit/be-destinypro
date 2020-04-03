package com.github.fairit.destinypro.controller;

import com.github.fairit.destinypro.dto.exception.ApiErrorDto;
import com.github.fairit.destinypro.exception.ApiNotFoundException;
import com.github.fairit.destinypro.exception.CharacterNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler({CharacterNotFoundException.class})
    public ResponseEntity<ApiErrorDto> handleEntityNotFound(CharacterNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(create(exception));
    }

    @ExceptionHandler({ApiNotFoundException.class})
    public ResponseEntity<ApiErrorDto> handleEntityNotFound(ApiNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(create(exception));
    }

    private ApiErrorDto create(Exception exception) {
        ApiErrorDto errorDto = new ApiErrorDto();
        errorDto.setExceptionClass(exception.getClass().getCanonicalName());
        errorDto.setMessage(exception.getMessage());
        return errorDto;
    }
}
