package com.defineXfinalcase.model;

import javax.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class SMS extends BaseModel{
    private String message;
    private LocalDate timeToSend;
}
