package com.hatzlhoffer.easybank.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hatzlhoffer.easybank.model.Cards;

public interface CardsRepository extends CrudRepository<Cards, Long> {

	List<Cards> findByCustomerId(int customerId);

}
