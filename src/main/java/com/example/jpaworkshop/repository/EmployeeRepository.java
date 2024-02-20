package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.model.dto.EmployeeDto;
import com.example.jpaworkshop.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<EmployeeDto> findByLastName(String lastName);

    @Modifying
    @Query(value = "UPDATE Employee e set e.salary = :salary where e.lastName = :lastName")
    void updateSalaryOfEmployee(@Param("salary")BigDecimal salary,@Param("lastName") String lastName);

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :minSalary AND :maxSalary")
    List<Employee> findEmployeesBySalaryRange(@Param("minSalary") BigDecimal minSalary, @Param("maxSalary") BigDecimal maxSalary);



}
