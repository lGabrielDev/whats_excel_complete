package br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions;

public class ItemsLengthIsWrongException extends RuntimeException{

    //constructors
    public ItemsLengthIsWrongException(String errorMessage){
       super(errorMessage);
   }
}
