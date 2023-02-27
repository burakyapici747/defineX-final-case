package com.defineXfinalcase.service;

import com.defineXfinalcase.api.request.CustomerPostRequest;
import com.defineXfinalcase.api.request.CustomerPutRequest;
import com.defineXfinalcase.api.response.BaseResponse;
import com.defineXfinalcase.api.response.DataResponse;
import com.defineXfinalcase.dto.CreditApplicationDto;
import com.defineXfinalcase.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    DataResponse<List<CustomerDto>> getAll();
    DataResponse<CustomerDto> getById(String id);
    /*
        DataResponse<List<SMSDto>> getAllSMSByCustomerId(String customerId);
    */
    DataResponse<CreditApplicationDto> submitCreditApplicationById(String id);
    int getCreditScoreById(String id);
    BaseResponse deleteById(String id);
    DataResponse<CustomerDto> create(CustomerPostRequest customerPostRequest);
    DataResponse<CustomerDto> updateById(String id, CustomerPutRequest customerPutRequest);
}
