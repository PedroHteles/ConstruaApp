package com.example.demo5.controllers;

import com.example.demo5.domain.Cliente;
import com.example.demo5.dtos.AuthenticationResponse;
import com.example.demo5.dtos.LoginDTO;
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
    public ResponseEntity<AuthenticationResponse> register(@RequestBody Cliente newCliente) {
        boolean register = authService.register(newCliente);
        if (register) {
            return ResponseUtil.createOkResponse(authService.getCliente(newCliente.getEmail()));
        } else {
            return ResponseUtil.createUnauthorizedResponse("Unauthorized");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginDTO loginDTO) {
        AuthenticationResponse response = authService.authenticate(loginDTO.getEmail(), loginDTO.getPassword());
        if (response != null) {
            return ResponseUtil.createOkResponse(response);
        } else {
            return ResponseUtil.createUnauthorizedResponse("Unauthorized");
        }
    }

}
