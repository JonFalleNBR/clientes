package io.github.jonfallenbr.apiclientes.model.repository;


import io.github.jonfallenbr.apiclientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
