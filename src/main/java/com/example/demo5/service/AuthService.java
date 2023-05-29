package com.example.demo5.service;

import com.example.demo5.domain.Cliente;
import com.example.demo5.repositories.ClienteRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private ClienteRepositoryJPA clienteRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String authenticate(String email, String password) {
        Cliente cliente = clienteRepository.findByEmail(email);
        if (cliente != null && passwordEncoder.matches(password, cliente.getSenha())) {
            return jwtTokenProvider.createToken(email);
        }
        return null;
    }

    public boolean register(Cliente newCliente) {
        Cliente cliente = clienteRepository.findByEmail(newCliente.getEmail());
        if (cliente != null) {
            // Usuário já registrado
            return false;
        }

        // Criptografe a senha antes de salvá-la no banco de dados
        newCliente.setSenha(passwordEncoder.encode(newCliente.getSenha()));
        clienteRepository.save(newCliente);
        return true;
    }
}
