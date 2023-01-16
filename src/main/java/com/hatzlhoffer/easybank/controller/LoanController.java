package com.hatzlhoffer.easybank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
    @GetMapping("/myloans")
    public String getMyAccount() {
        return "Here are the loans details";
    }
}
