package com.defineXfinalcase.model;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
public class Role extends BaseModel{
    private String name;

}