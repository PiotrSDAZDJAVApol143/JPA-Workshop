package com.example.jpaworkshop.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateSalaryRequest {
    private BigDecimal newSalary;
}
