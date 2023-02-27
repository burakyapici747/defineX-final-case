package com.defineXfinalcase.api.request;

import lombok.Data;


@Data
public class CustomerPutRequest {
    private String name;
    private String surname;
    private double monthlyIncome;
    private String phoneNumber;
    private double assurance;
}
