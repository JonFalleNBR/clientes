package io.github.jonfallenbr.apiclientes.rest;

import io.github.jonfallenbr.apiclientes.model.entity.Usuario;
import io.github.jonfallenbr.apiclientes.model.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody @Valid Usuario usuario){
        usuarioRepository.save(usuario);


    }

}
