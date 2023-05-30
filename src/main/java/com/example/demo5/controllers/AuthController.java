package com.example.demo5.controllers;

import com.example.demo5.domain.Cliente;
import com.example.demo5.dtos.AuthenticationResponse;
import com.example.demo5.service.AuthService;
import com.example.demo5.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<AuthenticationResponse> login(@RequestParam("email") String email, @RequestParam("password") String password) {
        AuthenticationResponse response = authService.authenticate(email, password);
        if (response != null) {
            return ResponseUtil.createOkResponse(response);
        } else {
            return ResponseUtil.createUnauthorizedResponse("Unauthorized");
        }
    }

}
