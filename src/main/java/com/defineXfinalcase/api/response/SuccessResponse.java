package com.defineXfinalcase.api.response;

public class SuccessResponse extends BaseResponse{
    public SuccessResponse(String message) {
        super(true, message);
    }
}
