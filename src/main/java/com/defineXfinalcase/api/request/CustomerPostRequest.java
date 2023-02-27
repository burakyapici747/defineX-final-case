package com.defineXfinalcase.api.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerPostRequest {
    private String name;
    private String surname;
    private double monthlyIncome;
    private String phoneNumber;
    private LocalDate birthOfDate;
    private int creditScore;
    private double assurance;
}
