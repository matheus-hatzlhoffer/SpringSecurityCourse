package com.hatzlhoffer.easybank.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hatzlhoffer.easybank.model.Customer;
import com.hatzlhoffer.easybank.repository.CustomerRepository;

@RestController()
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<String> singUp(@RequestBody Customer customer) {
        ResponseEntity<String> response;
        try {
            String hashPassword = passwordEncoder.encode(customer.getPwd());
            Customer newCustomer = new Customer(customer.getName(), customer.getEmail(), customer.getMobileNumber(),
                    hashPassword, customer.getRole());
            customerRepository.save(newCustomer);
            response = ResponseEntity.status(HttpStatus.CREATED)
                    .body("User " + newCustomer.getEmail() + " is successfully resgistered");
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + e.getMessage());
        }
        return response;
    }

    @RequestMapping("")
    public Customer getUserDetailAfterLogin(Authentication authentication) {
        Optional<Customer> customerOptional = customerRepository.findByEmail(authentication.getName());
        if (customerOptional.isPresent()) {
            return customerOptional.get();
        } else {
            return null;
        }
    }
}
