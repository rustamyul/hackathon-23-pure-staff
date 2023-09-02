package ru.smbr.hackathon.controller.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.smbr.hackathon.exception.ApplicationServiceException;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ApplicationServiceException.class)
    public final ResponseEntity<HttpStatus> handleExceptions(ApplicationServiceException exception) {
        HttpStatus status = exception.getHttpStatus();
        log.error("#" + exception.getMethodName() +
                ": Got exception '" + exception.getMessage() +
                "', status: " + status);
        return ResponseEntity.status(status)
                .body(status);
    }
}
