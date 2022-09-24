package com.ciclo3.saloneventos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "El nombre del cliente no puede ser un numero")
public class ClientMalformedException extends RuntimeException{

    public ClientMalformedException(String message) {
        super(message);
    }
    
}
