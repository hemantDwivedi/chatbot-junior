package com.devexmaven.chatbotserver.exception;

public class ErrorDetails {
    private int status;
    private String message;

    public ErrorDetails(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
