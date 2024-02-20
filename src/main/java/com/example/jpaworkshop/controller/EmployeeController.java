package com.example.jpaworkshop.controller;

import com.example.jpaworkshop.model.dto.EmployeeDto;
import com.example.jpaworkshop.model.dto.NewEmployeeReq;
import com.example.jpaworkshop.model.dto.UpdateSalaryRequest;
import com.example.jpaworkshop.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/new")
    public ResponseEntity<Void> saveEmployee(@RequestBody NewEmployeeReq newEmployee) {
        employeeService.saveEmployee(newEmployee);

        return ResponseEntity.ok().build();
    }
    @GetMapping("/findByLastName")
    public ResponseEntity<EmployeeDto> getEmployeeByLastName(@RequestParam String lastName){
        EmployeeDto employeeDto = employeeService.findByLastName(lastName);
        if (employeeDto != null) {
            return ResponseEntity.ok(employeeDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/updateEmployee/salary/{lastName}")
    public ResponseEntity<Void> updateSalaryOfEmployee(@PathVariable String lastName, @RequestBody UpdateSalaryRequest updateSalaryRequest) {
        employeeService.updateEmployeeSalary(lastName, updateSalaryRequest.getNewSalary());
        return ResponseEntity.ok().build();
    }
    @GetMapping("/employeesBySalaryRange")
    public ResponseEntity<List<EmployeeDto>> getEmployeesBySalaryRange(@RequestParam BigDecimal minSalary, @RequestParam BigDecimal maxSalary) {
        List<EmployeeDto> employeeDtos = employeeService.findEmployeesBySalaryRange(minSalary, maxSalary);
        return ResponseEntity.ok(employeeDtos);
    }
}
