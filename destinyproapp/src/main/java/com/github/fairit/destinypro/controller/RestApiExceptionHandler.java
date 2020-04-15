package com.github.fairit.destinypro.controller;

import com.github.fairit.destinypro.dto.exception.ErrorDto;
import com.github.fairit.destinypro.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler({PlayerNotFoundException.class})
    public ResponseEntity<ErrorDto> handleEntityNotFound(final PlayerNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(create(exception));
    }

    @ExceptionHandler({CharacterNotFoundException.class})
    public ResponseEntity<ErrorDto> handleEntityNotFound(final CharacterNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(create(exception));
    }

    @ExceptionHandler({ApiNotFoundException.class})
    public ResponseEntity<ErrorDto> handleEntityNotFound(final ApiNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(create(exception));
    }

    @ExceptionHandler({BadPlayerRequestException.class})
    public ResponseEntity<ErrorDto> handleEntityNotFound(final BadPlayerRequestException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(create(exception));
    }

    @ExceptionHandler({NicknameCannotBeEmptyException.class})
    public ResponseEntity<ErrorDto> handleEntityNotFound(final NicknameCannotBeEmptyException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(create(exception));
    }

    @ExceptionHandler({BadDestinyManifestRequestException.class})
    public ResponseEntity<ErrorDto> handleEntityNotFound(final BadDestinyManifestRequestException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(create(exception));
    }

    @ExceptionHandler({ActivityStatsNotFoundException.class})
    public ResponseEntity<ErrorDto> handleEntityNotFound(final ActivityStatsNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(create(exception));
    }

    private ErrorDto create(final Exception exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setExceptionClass(exception.getClass().getCanonicalName());
        errorDto.setMessage(exception.getMessage());
        return errorDto;
    }
}
