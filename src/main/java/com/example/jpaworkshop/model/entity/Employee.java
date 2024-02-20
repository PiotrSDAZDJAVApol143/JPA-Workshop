package com.example.jpaworkshop.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String firstName;
    private String lastName;
    //@Column(name = "wynagrodzenie", nullable = false, length = 3)
    private BigDecimal salary;
    private LocalDate contractEnd;
    @ManyToOne
    @JoinColumn(name = "dep_id")
    @JsonBackReference
    private Department department;

    @OneToOne
    private EntryCard entryCard;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    @JsonBackReference
    private Supervisor supervisor;

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", contractEnd=" + contractEnd +
                ", entryCard=" + entryCard +
                '}';
    }
}
