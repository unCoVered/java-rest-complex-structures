package com.returnly.assessment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {
    private static Logger LOGGER = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    @ExceptionHandler(IOException.class)
    public void handleIOException() {
        LOGGER.info("Error parsing ORDERs JSON");
    }
}
