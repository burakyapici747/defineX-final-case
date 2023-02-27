package com.defineXfinalcase.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Credit extends BaseModel{
    private double creditLimit;
    private double collateralAmount;
}
