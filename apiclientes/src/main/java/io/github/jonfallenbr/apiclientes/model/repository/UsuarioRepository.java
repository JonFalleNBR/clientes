package io.github.jonfallenbr.apiclientes.model.repository;


import io.github.jonfallenbr.apiclientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


}
