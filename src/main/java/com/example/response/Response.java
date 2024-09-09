package com.example.response;

public class Response {
    private String message;
    private Boolean success = true;
    private int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Response() {
    }

    public Response(String message, int status) {
        this.message = message;
        this.success = true;
        this.status = status;
    }
}
