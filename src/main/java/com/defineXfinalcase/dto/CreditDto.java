package com.defineXfinalcase.dto;

import com.defineXfinalcase.enums.CreditResult;
import com.defineXfinalcase.model.Credit;
import lombok.Data;

@Data
public class CreditDto {
    private CreditResult creditResult;
    private Credit credit;
}
