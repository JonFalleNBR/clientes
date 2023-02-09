package io.github.jonfallenbr.apiclientes.model.repository;

import io.github.jonfallenbr.apiclientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
