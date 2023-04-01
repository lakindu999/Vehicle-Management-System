package com.lakiprojects.vms.advisor;

import com.lakiprojects.vms.exception.NotFoundException;
import com.lakiprojects.vms.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404,"ERROR FOUND ",e.getMessage()), HttpStatus.NOT_FOUND
        );
    }
}
