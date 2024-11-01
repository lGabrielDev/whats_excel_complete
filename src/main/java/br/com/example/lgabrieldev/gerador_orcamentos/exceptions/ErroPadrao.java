package br.com.example.lgabrieldev.gerador_orcamentos.exceptions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ErroPadrao {
    
    //attributes
    private String errorMessage;
    private LocalDateTime timestamp;
    private Integer statusCode;

    //constructors
    public ErroPadrao(){}

    public ErroPadrao(String errorMessage, LocalDateTime timestamp, Integer statusCode){
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    //getters and setters
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getTimestamp() {
        timestamp = LocalDateTime.now();
        DateTimeFormatter formatacaoPadrao = DateTimeFormatter.ofPattern("yyyy-MM-dd  hh:mm:ss a");
        return formatacaoPadrao.format(this.timestamp);
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    
    
}
