package io.github.jonfallenbr.apiclientes.rest;

import io.github.jonfallenbr.apiclientes.exception.UsuarioCadastradoException;
import io.github.jonfallenbr.apiclientes.model.entity.Usuario;
import io.github.jonfallenbr.apiclientes.model.repository.UsuarioRepository;
import io.github.jonfallenbr.apiclientes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

   // @Autowired
    private final UsuarioService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){
        try{
            service.salvar(usuario);

        }catch (UsuarioCadastradoException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

}
