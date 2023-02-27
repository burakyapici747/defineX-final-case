package com.defineXfinalcase.model;

import com.defineXfinalcase.enums.CreditResult;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class CreditApplication extends BaseModel{
    private CreditResult creditResult;
    private double monthlyIncome;

    @ManyToOne
    private Customer customer;
}
