package ua.cats.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Slf4j
@RestControllerAdvice
public class CatsExceptionHandler {
    @ExceptionHandler(value = CatNotFoundException.class)
    public ResponseEntity<ErrorMessage> catNotFoundException(CatNotFoundException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                new Date(),
                exception.getMessage(),
                request.getDescription(false));
        log.error(exception.getMessage(), exception);
        return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }
}
