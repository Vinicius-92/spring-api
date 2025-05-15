package dev.vinicissilva.springapi.handlers;

import dev.vinicissilva.springapi.exceptions.ExceptionResponse;
import dev.vinicissilva.springapi.exceptions.UserNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler({UserNotFoundException.class})
  public ResponseEntity<ExceptionResponse> handleUserNotFoundException(Exception e) {
    log.info(e.getClass().toString());
    return new ResponseEntity<>(
        new ExceptionResponse(
            HttpStatus.UNAUTHORIZED.getReasonPhrase(),
            HttpStatus.UNAUTHORIZED.value(),
            e.getMessage()),
        HttpStatus.UNAUTHORIZED);
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler({Exception.class})
  public ResponseEntity<ExceptionResponse> handleException(Exception e) {
    log.info(e.getClass().toString());
    return ResponseEntity.internalServerError()
        .body(
            new ExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                e.getMessage()));
  }
}
