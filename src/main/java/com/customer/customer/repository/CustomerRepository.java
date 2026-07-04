package com.customer.customer.repository;

import com.customer.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // JpaRepository already deta hai:
    // save(), findAll(), findById(), deleteById(), count(), etc.

    // Custom query example (agar future mein chahiye ho):
    // Optional<Customer> findByEmail(String email);
}