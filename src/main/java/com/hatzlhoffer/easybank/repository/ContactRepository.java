package com.hatzlhoffer.easybank.repository;

import org.springframework.data.repository.CrudRepository;

import com.hatzlhoffer.easybank.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
