package com.defineXfinalcase.model;

import javax.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer extends BaseModel{
    private String name;
    private String surname;
    private double monthlyIncome;
    private String phoneNumber;
    private LocalDate birthOfDate;
    private int creditScore;
    private double assurance;
    private LocalDate dateOfBirth;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SMS> smsList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Credit> credits = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CreditApplication> creditApplications = new ArrayList<>();
}