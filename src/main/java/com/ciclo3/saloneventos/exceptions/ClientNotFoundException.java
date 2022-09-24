package com.ciclo3.saloneventos.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No existe el cliente")
public class ClientNotFoundException extends RuntimeException  {

    public ClientNotFoundException(Long id) {
        super(String.format(String.format("Cliente con el id: %s no se encuentra",id)));
    }
    
    public ClientNotFoundException(String message) {
        super(message);
    }
}
