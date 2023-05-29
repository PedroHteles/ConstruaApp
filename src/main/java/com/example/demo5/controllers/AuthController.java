package com.example.demo5.controllers;

import com.example.demo5.domain.Cliente;
import com.example.demo5.dtos.AuthenticationResponse;
import com.example.demo5.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public boolean register(@RequestBody Cliente newCliente) {
        return authService.register(newCliente);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestParam("email") String email, @RequestParam("password") String password) {
        AuthenticationResponse token = authService.authenticate(email, password);
        if (token != null) {
            return token;
        } else {
            return null;
        }
    }
}
