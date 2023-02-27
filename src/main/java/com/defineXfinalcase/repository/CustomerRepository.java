package com.defineXfinalcase.repository;

import com.defineXfinalcase.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    /*
    List<SMS> findAllSMSByCustomerId(UUID customerId);
    */
    Optional<Customer> findByIdAndAndBirthOfDate(UUID id, LocalDate birthOfDate);
}
