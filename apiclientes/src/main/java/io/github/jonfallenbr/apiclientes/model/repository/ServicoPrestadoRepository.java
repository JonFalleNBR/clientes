package io.github.jonfallenbr.apiclientes.model.repository;

import io.github.jonfallenbr.apiclientes.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado, Integer> {

    @Query("SELECT s FROM ServicoPrestado s JOIN s.cliente c " +
            "WHERE UPPER(c.nome) LIKE UPPER(CONCAT('%', :nome, '%')) AND MONTH(s.data) = :mes")
    List<ServicoPrestado> findByNomeClienteAndMes(@Param("nome") String nome,
                                                  @Param("mes") Integer mes);
}
