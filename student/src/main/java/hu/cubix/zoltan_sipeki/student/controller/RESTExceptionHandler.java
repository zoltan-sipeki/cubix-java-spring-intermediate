package hu.cubix.zoltan_sipeki.student.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import hu.cubix.zoltan_sipeki.student.exception.EntityNotFoundException;

@RestControllerAdvice
public class RESTExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ProblemDetail> handleEntityNotFound(EntityNotFoundException e) {
        return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage())).build();
    }
}
