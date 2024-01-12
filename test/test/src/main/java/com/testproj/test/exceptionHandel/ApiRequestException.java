package com.testproj.test.exceptionHandel;

import org.springframework.http.HttpStatus;

public class ApiRequestException extends ApiBaseException{
    public ApiRequestException(String message) {
        super(message);

    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}
