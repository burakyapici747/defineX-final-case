package com.defineXfinalcase.api.response;

public class ErrorResponse extends BaseResponse{
    public ErrorResponse(String message) {
        super(false, message);
    }
}
