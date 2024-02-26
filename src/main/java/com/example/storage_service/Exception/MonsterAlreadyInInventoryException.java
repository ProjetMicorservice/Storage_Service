package com.example.storage_service.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MonsterAlreadyInInventoryException extends RuntimeException {
    public MonsterAlreadyInInventoryException(String message) {
        super(message);
    }
}