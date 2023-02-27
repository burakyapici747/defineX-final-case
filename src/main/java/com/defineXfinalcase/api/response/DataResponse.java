package com.defineXfinalcase.api.response;

public class DataResponse<T> extends BaseResponse{
    public final T data;

    public DataResponse(boolean isSuccess, T data, String message) {
        super(isSuccess, message);
        this.data = data;
    }
}
