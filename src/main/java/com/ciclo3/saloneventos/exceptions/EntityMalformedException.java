package com.ciclo3.saloneventos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "El tipo de dato no es el adecuado")
public class EntityMalformedException extends RuntimeException{

    public EntityMalformedException(String message) {
        super(message);
    }
    
}
