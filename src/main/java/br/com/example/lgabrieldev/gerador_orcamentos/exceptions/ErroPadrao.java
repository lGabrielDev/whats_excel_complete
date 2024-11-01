package br.com.example.lgabrieldev.gerador_orcamentos.exceptions;

public class ErroPadrao {
    
    //attributes
    private String errorMessage;
    private String timestamp;
    private Integer statusCode;

    //constructors
    public ErroPadrao(String errorMessage, String timestamp, Integer statusCode){
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
        this.statusCode = statusCode;
    }

    //getters and setters
    
}
