package io.github.jonfallenbr.apiclientes.rest;


import io.github.jonfallenbr.apiclientes.rest.exception.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@ControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationErrors(MethodArgumentNotValidException ex){
        BindingResult bindingResult =  ex.getBindingResult();
        List<String> messages =  bindingResult.getAllErrors()
                .stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList() );
        return new ApiErrors(messages);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity handleResponseStatusException(ResponseStatusException ex){
         String mensagemErro = ex.getMessage();
         HttpStatus codigoStatus = ex.getStatus();
         ApiErrors apiErrors= new ApiErrors(mensagemErro);
         return new ResponseEntity(apiErrors, codigoStatus);
    }
}
/*
   Validação do retorno do tratamento de erros, chamando a classe ApiErrors (linha 24), e colocando dentro de uma lista ordenada e retornando de forma organizada e concatenada
 */