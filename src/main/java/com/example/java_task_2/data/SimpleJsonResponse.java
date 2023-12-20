package com.example.java_task_2.data;

public class SimpleJsonResponse {
    private String message;
    private int statusCode;
    private boolean error;

    public SimpleJsonResponse(String message, int statusCode, boolean error) {
        this.message = message;
        this.statusCode = statusCode;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
