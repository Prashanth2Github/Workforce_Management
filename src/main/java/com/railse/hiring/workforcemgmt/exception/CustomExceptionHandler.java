package com.railse.hiring.workforcemgmt.exception;

import com.railse.hiring.workforcemgmt.response.Response;
import com.railse.hiring.workforcemgmt.response.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Response<Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ResponseStatus status = new ResponseStatus(StatusCode.NOT_FOUND.getCode(), ex.getMessage());
        return new ResponseEntity<>(new Response<>(null, null, status), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Response<Object>> handleAllExceptions(Exception ex) {
        ResponseStatus status = new ResponseStatus(
                StatusCode.INTERNAL_SERVER_ERROR.getCode(),
                "Unexpected error: " + ex.getMessage()
        );
        return new ResponseEntity<>(new Response<>(null, null, status), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
