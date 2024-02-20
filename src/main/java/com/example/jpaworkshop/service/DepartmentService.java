package com.example.jpaworkshop.service;

import com.example.jpaworkshop.model.dto.DepartmentDto;
import com.example.jpaworkshop.model.entity.Department;
import com.example.jpaworkshop.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public Department findDepartmentByName(String name) {
        Optional<Department> optionalDepartment = departmentRepository.findByName(name);

        return optionalDepartment.orElse(null);
    }

  //  public void saveDepartment(Department newDepartment) {
  //      Department newDev = new Department();
  //      newDev.setName(newDepartment.getName());
  //      newDev.setAddress(newDepartment.getAddress());
  //      newDev.setEmployees(newDepartment.getEmployees());
//
  //      departmentRepository.save(newDev);
  //  }
  @Transactional(rollbackFor = SQLException.class)
    public void saveDepartment(DepartmentDto newDepartmentDto) {
      Department newDepartment = departmentMapper.toEntity(newDepartmentDto);
      departmentRepository.save(newDepartment);
  }

    public List<Department> findDepartmentsByCity(String city) {
        return departmentRepository.findAllByAddress_City(city);
    }

    public List<DepartmentDto> findAllByName(String departmentName) {
        List<Department> allByName = departmentRepository.findAllByName(departmentName);
        return allByName.stream()
                .map(entity -> departmentMapper.toDto(entity))
                .collect(Collectors.toList());
    }
}
