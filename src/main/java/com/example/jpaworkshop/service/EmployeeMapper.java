package com.example.jpaworkshop.service;

import com.example.jpaworkshop.model.dto.EmployeeDto;
import com.example.jpaworkshop.model.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeDto toDto(Employee entity){
        EmployeeDto dto = new EmployeeDto();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setSalary(entity.getSalary());
        dto.setContractEnd(entity.getContractEnd());

        return dto;

    }



}
