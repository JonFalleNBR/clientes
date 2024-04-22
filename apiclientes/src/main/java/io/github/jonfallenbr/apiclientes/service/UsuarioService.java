package io.github.jonfallenbr.apiclientes.service;

import io.github.jonfallenbr.apiclientes.exception.UsuarioCadastradoException;
import io.github.jonfallenbr.apiclientes.model.entity.Usuario;
import io.github.jonfallenbr.apiclientes.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        boolean exists = usuarioRepository.existsByUsername(usuario.getUsername());
        if(exists){
            throw new UsuarioCadastradoException((usuario.getUsername()));
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Login não encontrado"));

        return User
                .builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER")
                .build();
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }
}
/*
User com o builder tem o objetivo de "transformar" o usuario em um UserDetails, que é o padrão de usuario do Spring e deve ser retornado ao final do metodo
 */