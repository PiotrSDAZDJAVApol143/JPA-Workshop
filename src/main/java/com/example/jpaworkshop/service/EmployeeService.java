package com.example.jpaworkshop.service;

import com.example.jpaworkshop.model.dto.EmployeeDto;
import com.example.jpaworkshop.model.dto.NewEmployeeReq;
import com.example.jpaworkshop.model.entity.Employee;
import com.example.jpaworkshop.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public void saveEmployee(NewEmployeeReq req) {

        Employee newEmployeeEntity = new Employee();
        newEmployeeEntity.setFirstName(req.getFirstName());
        newEmployeeEntity.setLastName(req.getLastName());
        newEmployeeEntity.setSalary(req.getSalary());
        newEmployeeEntity.setContractEnd(req.getContractEnd());

        employeeRepository.save(newEmployeeEntity);
    }
    public EmployeeDto findByLastName(String lastName){
        Optional<EmployeeDto> optionalEmployeeDto = employeeRepository.findByLastName(lastName);
        return optionalEmployeeDto.orElse(null);
    }
    @Transactional
    public void updateEmployeeSalary(String lastName, BigDecimal newSalary) {
        employeeRepository.updateSalaryOfEmployee(newSalary, lastName);
    }

    public List<EmployeeDto> findEmployeesBySalaryRange(BigDecimal minSalary, BigDecimal maxSalary) {
        List<Employee> employees = employeeRepository.findEmployeesBySalaryRange(minSalary, maxSalary);
        return employees
                .stream()
                .map(employeeMapper::toDto)
                .collect(Collectors.toList());
    }

}
