package com.defineXfinalcase.api.response;

public class SuccessDataResponse<T> extends DataResponse<T>{
    public SuccessDataResponse(T data, String message) {
        super(true, data, message);
    }
}
