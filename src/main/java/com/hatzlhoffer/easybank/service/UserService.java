package com.hatzlhoffer.easybank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hatzlhoffer.easybank.model.Customer;
import com.hatzlhoffer.easybank.repository.CustomerRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(username);
        Customer customer;
        try {
            customer = optionalCustomer.get();
        } catch (Exception e) {
            throw new UsernameNotFoundException("User details not found for the user: " + username);
        }
        return customer;
    }
}
