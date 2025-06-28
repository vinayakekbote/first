package com.first.Model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ErrorResponse {

    private String message;
    private LocalDate localDate;

    public ErrorResponse() {
    }

    public ErrorResponse(String message, LocalDate localDate) {
        this.message = message;
        this.localDate = localDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
