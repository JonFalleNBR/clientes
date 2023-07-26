package io.github.jonfallenbr.apiclientes.rest.exception;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> errors;

    public ApiErrors(List<String> errors) {
        this.errors = errors;
    }

    public ApiErrors(String message){
        this.errors = Arrays.asList(message);
    }
}

/*
    Tratamento de erros em um Array de mensagens para melhor visualização do usuário
 */
