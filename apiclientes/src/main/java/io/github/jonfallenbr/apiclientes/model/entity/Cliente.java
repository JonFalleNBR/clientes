package io.github.jonfallenbr.apiclientes.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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
    @NotEmpty(message = "{campo.nome.obrigatorio}")
    private String nome;

    @Column(nullable = false, length = 14)
    @NotEmpty(message = "{campo.cpf.obrigatorio}")
    //@CPF(message = "{campo.cpf.invalido}")
    private String cpf;

    @Column(name = "data_cadastro",updatable = false )
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
