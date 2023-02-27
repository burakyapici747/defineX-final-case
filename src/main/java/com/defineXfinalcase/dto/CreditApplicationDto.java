package com.defineXfinalcase.dto;

import com.defineXfinalcase.enums.CreditResult;
import lombok.Data;

@Data
public class CreditApplicationDto {
    private CreditResult creditResult;
    private double monthlyIncome;
    private CreditDto creditDto;
}
