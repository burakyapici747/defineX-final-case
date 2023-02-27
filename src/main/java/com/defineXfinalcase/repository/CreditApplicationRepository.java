package com.defineXfinalcase.repository;

import com.defineXfinalcase.model.CreditApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CreditApplicationRepository extends JpaRepository<CreditApplication, UUID> {
}
