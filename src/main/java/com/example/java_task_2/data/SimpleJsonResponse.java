package com.example.java_task_2.data;

public class SimpleJsonResponse {
    private String message;
    private int statusCode;
    private boolean success;

    public SimpleJsonResponse(String message, int statusCode, boolean success) {
        this.message = message;
        this.statusCode = statusCode;
        this.success = success;
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
