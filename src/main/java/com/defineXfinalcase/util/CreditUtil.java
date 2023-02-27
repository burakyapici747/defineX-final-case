package com.defineXfinalcase.util;

import com.defineXfinalcase.constant.CreditApplicationConstant;
import com.defineXfinalcase.dto.CreditDto;
import com.defineXfinalcase.enums.CreditResult;
import com.defineXfinalcase.model.Credit;
import com.defineXfinalcase.service.CreditService;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CreditUtil {
    public CreditDto getCreditResultByCustomerScoreAndSalary(int creditScore, double monthlyIncome, double assurance, CreditService creditService) {
        CreditDto creditDto = new CreditDto();

        double creditLimit = 0;

        if(creditScore < 500){
            creditDto = getCreditDto(CreditResult.REJECTION);
        }else if((creditScore >= 500 && creditScore <= 1000) && monthlyIncome < 5000){
            creditLimit = (10000 + (assurance * 0.1));
            creditDto = getCreditDto(CreditResult.APPROVAL, createCredit(creditService, creditLimit));
        }else if((creditScore >= 500 && creditScore <= 1000) && (monthlyIncome >= 5000 && monthlyIncome <= 10000)){
            creditLimit = (20000 + (assurance * 0.2));
            creditDto = getCreditDto(CreditResult.APPROVAL, createCredit(creditService, creditLimit));
        }else if((creditScore >= 500 && creditScore <= 1000) && monthlyIncome > 10000){
            creditLimit = (monthlyIncome * (CreditApplicationConstant.CREDIT_MULTIPLIER / 2));
            creditDto = getCreditDto(CreditResult.APPROVAL, createCredit(creditService, creditLimit));
        }else if(creditScore >= 1000){
            creditLimit = (monthlyIncome * CreditApplicationConstant.CREDIT_MULTIPLIER + (assurance * 0.1));
            creditDto = getCreditDto(CreditResult.APPROVAL, createCredit(creditService, creditLimit));
        }

        return creditDto;
    }

    public Credit createCredit(CreditService creditService, double creditLimit){
        Credit credit = new Credit();

        credit.setCreditLimit(creditLimit);

        creditService.createCredit(credit);

        return credit;
    }

    public CreditDto getCreditDto(CreditResult creditResult){
        final CreditDto creditDto = new CreditDto();

        creditDto.setCreditResult(creditResult);

        return creditDto;
    }

    public CreditDto getCreditDto(CreditResult creditResult, Credit credit){
        final CreditDto creditDto = new CreditDto();

        creditDto.setCreditResult(creditResult);
        creditDto.setCredit(credit);

        return creditDto;
    }
}
