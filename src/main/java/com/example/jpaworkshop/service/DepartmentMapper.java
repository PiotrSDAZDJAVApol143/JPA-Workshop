package com.example.jpaworkshop.service;

import com.example.jpaworkshop.model.dto.DepartmentDto;
import com.example.jpaworkshop.model.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public DepartmentDto toDto(Department entity){
        DepartmentDto dto = new DepartmentDto();
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());

        return dto;
    }

    public Department toEntity(DepartmentDto dto){
        Department entity = new Department();
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        return entity;
    }

}
