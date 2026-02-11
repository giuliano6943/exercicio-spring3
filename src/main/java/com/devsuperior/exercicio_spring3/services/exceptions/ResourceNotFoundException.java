package com.devsuperior.exercicio_spring3.services.exceptions;

//Exception utilizada quando um recurso não é encontrado
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
