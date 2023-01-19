package com.hatzlhoffer.easybank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hatzlhoffer.easybank.model.Accounts;
import com.hatzlhoffer.easybank.repository.AccountsRepository;

@RestController
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;

    @GetMapping("/myaccount")
    public Accounts getMyAccount(@RequestParam int id) {
        System.out.println("Here");
        Accounts accounts = accountsRepository.findByCustomerId(id);
        if (accounts != null) {
            System.out.println("Here2");
            return accounts;
        } else {
            return null;
        }
    }
}
