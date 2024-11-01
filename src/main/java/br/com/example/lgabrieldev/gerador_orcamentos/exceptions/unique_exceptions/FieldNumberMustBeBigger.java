package br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions;

public class FieldNumberMustBeBigger extends RuntimeException{

    //constructors
    public FieldNumberMustBeBigger(String errorMessage){
       super(errorMessage);
   }
}
