package com.chinu.Dto;

public class ErrorDto {
    private String message;

    public String getMessage() {
        return message;
    }

    public ErrorDto(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
