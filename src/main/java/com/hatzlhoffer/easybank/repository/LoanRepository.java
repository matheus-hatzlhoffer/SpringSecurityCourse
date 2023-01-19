package com.hatzlhoffer.easybank.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hatzlhoffer.easybank.model.Loans;

public interface LoanRepository extends CrudRepository<Loans, Long> {

	List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);

}
