package com.defineXfinalcase.api.response;

public class ErrorDataResponse<T> extends DataResponse<T>{
    public ErrorDataResponse(T data, String message) {
        super(false, data, message);
    }
}
