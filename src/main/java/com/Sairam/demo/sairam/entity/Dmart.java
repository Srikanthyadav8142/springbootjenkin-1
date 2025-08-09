package com.Sairam.demo.sairam.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Dmart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String itemName;
    private int price;
}
