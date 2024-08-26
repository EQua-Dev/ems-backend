package com.awesomenessstudios.ems_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
* This is the class for the "resource not found" exception
* The annotation "ResponseStatus" is passed to make the class to return the not found http status code when called.
* The object within the class attaches the passed message to the "Not Found" http status
* */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
