package com.ciclo3.saloneventos.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Esta peticion es a una api invalida")
public class ApiMalformedException extends RuntimeException{

    public ApiMalformedException(String message) {
        super("Llamados a api invalida: " + message);
    }
    
}
