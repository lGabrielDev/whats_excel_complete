package br.com.example.lgabrieldev.gerador_orcamentos.exceptions;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.fasterxml.jackson.databind.JsonMappingException;
import br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions.FieldCannotBeNullException;
import br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions.FieldLengthIsWrongException;
import br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions.FieldNumberMustBeBigger;
import br.com.example.lgabrieldev.gerador_orcamentos.exceptions.unique_exceptions.ItemsLengthIsWrongException;

@ControllerAdvice
public class GlobalExceptionHandler {
    

    // ======== field cannot be null ========
    @ExceptionHandler(FieldCannotBeNullException.class)
    public ResponseEntity<ErroPadrao> fieldCannotBeNullExceptionHandler(FieldCannotBeNullException e){
        
        ErroPadrao erroPadrao = new ErroPadrao(
            e.getMessage(),
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.badRequest().body(erroPadrao);
    }

    // ======== field length is wrong ========
    @ExceptionHandler(FieldLengthIsWrongException.class)
    public ResponseEntity<ErroPadrao> fieldLengthIsWrongException(FieldLengthIsWrongException e){
        
        ErroPadrao erroPadrao = new ErroPadrao(
            e.getMessage(),
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.badRequest().body(erroPadrao);
    }

    // ======== field must be bigger than 0 ========
    @ExceptionHandler(FieldNumberMustBeBigger.class)
    public ResponseEntity<ErroPadrao> fieldNumberMustBeBiggerHandler(FieldNumberMustBeBigger e){
        
        ErroPadrao erroPadrao = new ErroPadrao(
            e.getMessage(),
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.badRequest().body(erroPadrao);
    }

    // ======== field must be bigger than 0 ========
    @ExceptionHandler(ItemsLengthIsWrongException.class)
    public ResponseEntity<ErroPadrao> itemsLengthIsWrongExceptionHandler(ItemsLengthIsWrongException e){
        
        ErroPadrao erroPadrao = new ErroPadrao(
            e.getMessage(),
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value()
        );
        return ResponseEntity.badRequest().body(erroPadrao);
    }

    // ======== field cannot be a String ========
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroPadrao> HttpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e){
        
        //encontramos o campo/attribute que aconteceu o erro
        JsonMappingException jsonMapping = (JsonMappingException) e.getCause();
        String campoDoErro = jsonMapping.getPath().get(0).getFieldName();

        String errorMessage = String.format(" '%s' cannot be a String", campoDoErro) ;


        if(campoDoErro.equals("items")){
            errorMessage = " 'valorUnit' and 'quantity' cannot be Strings. Check your items!";
        }

        ErroPadrao erroPadrao = new ErroPadrao();
        erroPadrao.setStatusCode(HttpStatus.BAD_REQUEST.value());
        erroPadrao.setTimestamp(LocalDateTime.now());
        erroPadrao.setErrorMessage(errorMessage);




        return ResponseEntity.badRequest().body(erroPadrao);
    }
}
