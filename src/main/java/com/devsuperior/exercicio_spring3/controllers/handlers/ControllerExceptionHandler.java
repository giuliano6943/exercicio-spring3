package com.devsuperior.exercicio_spring3.controllers.handlers;

import com.devsuperior.exercicio_spring3.dto.CustomError;
import com.devsuperior.exercicio_spring3.dto.ValidationError;
import com.devsuperior.exercicio_spring3.services.exceptions.DatabaseException;
import com.devsuperior.exercicio_spring3.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
//Intercepta exceptions dos controllers, basicamente um tradutor de excessoes
@ControllerAdvice
public class ControllerExceptionHandler {

    //Basicamente diz que quando essa excessao acontecer, execute esse metodo.
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(
            ResourceNotFoundException e,
            HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND; //404
        CustomError err = new CustomError(
                Instant.now(),
                status.value(),
                e.getMessage(),
                request.getRequestURI()//CAMINHO DA REQUISICAO
        );
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> databaseException(
            DatabaseException e,
            HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST; //400
        CustomError err = new CustomError(
                Instant.now(),
                status.value(),
                e.getMessage(),
                request.getRequestURI()//CAMINHO DA REQUISICAO
        );
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidation(
            MethodArgumentNotValidException e,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError(
                Instant.now(),
                status.value(),
                e.getMessage(),
                request.getRequestURI()
        );
        for(FieldError f : e.getBindingResult().getFieldErrors()) {
            err.addError(f.getField(), f.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(err);
    }
}
