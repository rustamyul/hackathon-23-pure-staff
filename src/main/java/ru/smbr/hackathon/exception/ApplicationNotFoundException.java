package ru.smbr.hackathon.exception;

import org.springframework.http.HttpStatus;

public class ApplicationNotFoundException extends ApplicationServiceException {

    public ApplicationNotFoundException(String methodName, String message) {
        super(methodName, message, HttpStatus.NOT_FOUND);
    }
}
