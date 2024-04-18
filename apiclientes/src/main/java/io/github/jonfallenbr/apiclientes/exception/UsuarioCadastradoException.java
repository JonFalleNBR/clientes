package io.github.jonfallenbr.apiclientes.exception;

public class UsuarioCadastradoException extends RuntimeException{

    public UsuarioCadastradoException(String login){
        super("Usuario ja Cadastrado para o Login: " + login);
    }
}
