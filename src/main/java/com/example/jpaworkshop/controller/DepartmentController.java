package com.example.jpaworkshop.controller;

import com.example.jpaworkshop.model.dto.DepartmentDto;
import com.example.jpaworkshop.model.entity.Department;
import com.example.jpaworkshop.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/findByName")
    public ResponseEntity<Department> findByName(@RequestParam String departName){
        Department departmentByName = departmentService.findDepartmentByName(departName);
        return ResponseEntity.ok(departmentByName);
    }

    @PostMapping("/new")
    public ResponseEntity<Void> saveDepartment(@RequestBody DepartmentDto newDepartmentDto){
        departmentService.saveDepartment(newDepartmentDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/findByCity")
    public ResponseEntity<List<Department>> findByCity(@RequestParam String city) {
        List<Department> departmentsByCity = departmentService.findDepartmentsByCity(city);
        return ResponseEntity.ok(departmentsByCity);
    }
    @GetMapping("/findAllByName")
    public ResponseEntity<List<DepartmentDto>> findAllByName(@RequestParam String departName){
        List<DepartmentDto> dtos = departmentService.findAllByName(departName);
        return ResponseEntity.ok(dtos);
    }


}
