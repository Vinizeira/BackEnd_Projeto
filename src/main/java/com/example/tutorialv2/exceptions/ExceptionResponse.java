package com.example.tutorialv2.exceptions;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
public class ExceptionResponse implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        private Date timestamp;
        private String message;
        private String details;


    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
