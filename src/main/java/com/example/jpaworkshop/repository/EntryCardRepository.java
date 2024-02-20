package com.example.jpaworkshop.repository;

import com.example.jpaworkshop.model.entity.EntryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryCardRepository extends JpaRepository<EntryCard, Long> {
}
