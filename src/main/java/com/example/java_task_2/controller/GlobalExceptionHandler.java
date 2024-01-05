package com.example.java_task_2.controller;

import com.example.java_task_2.data.SimpleJsonResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<SimpleJsonResponse> handleException(Exception e) {
        SimpleJsonResponse failedResponse = new SimpleJsonResponse(e.getMessage(), HttpStatus.OK.value(), false);

        return new ResponseEntity<>(failedResponse, new HttpHeaders(), HttpStatus.OK);
    }
}