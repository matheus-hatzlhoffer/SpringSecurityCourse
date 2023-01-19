package com.hatzlhoffer.easybank.repository;

import org.springframework.data.repository.CrudRepository;

import com.hatzlhoffer.easybank.model.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Long> {

	Accounts findByCustomerId(int customerId);

}
