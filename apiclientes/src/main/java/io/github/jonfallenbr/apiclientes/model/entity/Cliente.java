package io.github.jonfallenbr.apiclientes.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(name = "data_cadastro" )
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void PrePersist(){
        setDataCadastro(LocalDate.now());
    }
}

/*
Pesquisar sobre PrePersist, uso correto do Builder e Anotação de Bean na classe MainApplication,
onde supostamente é feito uma instancia de Dados de forma mais dinamica

 */
