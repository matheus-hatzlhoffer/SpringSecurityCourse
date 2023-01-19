package com.hatzlhoffer.easybank.repository;

import org.springframework.data.repository.CrudRepository;

import com.hatzlhoffer.easybank.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

}
