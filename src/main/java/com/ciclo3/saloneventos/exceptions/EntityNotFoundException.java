package com.ciclo3.saloneventos.exceptions;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No existe el valor buscado")
public class EntityNotFoundException extends RuntimeException {
    
    public EntityNotFoundException(Class<?> clazz, Long id){
        super(EntityNotFoundException.generateMessage(clazz.getSimpleName(),id));
    }
    
    public EntityNotFoundException(Class<?> clazz){
        super(EntityNotFoundException.generateMessage(clazz.getSimpleName()));
    }

    private static String generateMessage(String entity, Long id) {
        return StringUtils.capitalize(entity) +
            " was not found with the id:" + 
            id;
    }

    private static String generateMessage(String entity) {
        return StringUtils.capitalize(entity) +
            " was not found:";
    }
}
