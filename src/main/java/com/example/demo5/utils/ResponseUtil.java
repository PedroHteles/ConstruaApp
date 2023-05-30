package com.example.demo5.utils;

import com.example.demo5.dtos.AuthenticationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static <T> ResponseEntity<T> createResponse(HttpStatus status, T body) {
        return ResponseEntity.status(status).body(body);
    }

    // Exemplo de uso para retornar Unauthorized
    public static ResponseEntity<AuthenticationResponse> createUnauthorizedResponse(String message) {
        return createResponse(HttpStatus.UNAUTHORIZED, null);
    }

    public static <T> ResponseEntity<T> createOkResponse(T body) {
        return createResponse(HttpStatus.OK, body);
    }

    public static <T> ResponseEntity<T> createCreatedResponse(T body) {
        return createResponse(HttpStatus.CREATED, body);
    }

    public static ResponseEntity<?> createNotFoundResponse(String message) {
        return createResponse(HttpStatus.NOT_FOUND, message);
    }

    public static ResponseEntity<?> createInternalServerErrorResponse(String message) {
        return createResponse(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }

    // Outros métodos para lidar com diferentes códigos de status...

}
