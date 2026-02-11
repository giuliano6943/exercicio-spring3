package com.devsuperior.exercicio_spring3.services.exceptions;

//Usada quando há problemas de integridade com o banco
//Como quando quiser deletar um cliente que está dentro da tabela
public class DatabaseException extends RuntimeException{
    public DatabaseException(String message){
        super(message);
    }
}
