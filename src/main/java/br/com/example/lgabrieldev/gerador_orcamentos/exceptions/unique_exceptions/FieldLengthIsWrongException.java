package br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions;

public class FieldLengthIsWrongException extends RuntimeException{

     //constructors
     public FieldLengthIsWrongException(String errorMessage){
        super(errorMessage);
    }
}
