package br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions;

public class FieldCannotBeNullException extends RuntimeException{
    
    //constructors
    public FieldCannotBeNullException(String errorMessage){
        super(errorMessage);
    }
}
