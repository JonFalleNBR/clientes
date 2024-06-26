package io.github.jonfallenbr.apiclientes.model.repository;


import io.github.jonfallenbr.apiclientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);

    //select tabela de usuario e e dizer se ele existe  - select count (*) > 0 from usuario where username = :login
    boolean existsByUsername(String username);
}
/*
       Optional<Usuario> findByUsername(String username) chama a entidade Usuario e faz a busca no banco de dados, e essa interface é chamado na UsuarioService
 */