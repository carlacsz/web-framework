package com.webfw;

public class ApplicationException extends Exception {
    private int statusCode;

    public ApplicationException(String msg) {
        super(msg);
    }

    public ApplicationException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
