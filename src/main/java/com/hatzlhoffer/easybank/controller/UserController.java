package com.hatzlhoffer.easybank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hatzlhoffer.easybank.model.User;
import com.hatzlhoffer.easybank.repository.UserRepository;

@RestController()
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public ResponseEntity<String> singUp(@RequestBody User user) {
        ResponseEntity<String> response;
        try {
            String hashPassword = passwordEncoder.encode(user.getPassword());
            User newUser = new User(user.getUsername(), hashPassword);
            userRepository.save(newUser);
            response = ResponseEntity.status(HttpStatus.CREATED)
                    .body("User " + newUser.getUsername() + " is successfully resgistered");
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occured due to " + e.getMessage());
        }
        return response;
    }
}
