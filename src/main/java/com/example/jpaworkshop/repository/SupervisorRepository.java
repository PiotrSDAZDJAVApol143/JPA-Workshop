package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.model.entity.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupervisorRepository extends JpaRepository<Supervisor, Long> {
}
