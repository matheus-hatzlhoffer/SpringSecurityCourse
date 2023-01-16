package com.hatzlhoffer.easybank.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hatzlhoffer.easybank.model.User;
import com.hatzlhoffer.easybank.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        User user;
        try {
            user = optionalUser.get();
        } catch (Exception e) {
            throw new UsernameNotFoundException("User details not found for the user: " + username);
        }
        return user;
    }
}
