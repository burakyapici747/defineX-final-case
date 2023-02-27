package com.defineXfinalcase.repository;

import com.defineXfinalcase.model.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreditRepository extends JpaRepository<Credit, UUID> {
}
