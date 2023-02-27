package com.defineXfinalcase.api.response;

public abstract class BaseResponse {
    private boolean isSuccess;
    private String message;

    public BaseResponse(boolean isSuccess, String message) {
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getMessage() {
        return message;
    }
}
