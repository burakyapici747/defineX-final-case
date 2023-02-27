package com.defineXfinalcase.enums;

import com.defineXfinalcase.model.Credit;

public enum CreditResult {
    APPROVAL("Approval"),
    REJECTION("Rejection");

    private String result;
    CreditResult(String result){
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
