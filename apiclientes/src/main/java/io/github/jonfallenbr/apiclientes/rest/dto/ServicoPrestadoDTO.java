package io.github.jonfallenbr.apiclientes.rest.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ServicoPrestadoDTO {

    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    private String descricao;
    @NotEmpty(message = "{campo.preco.obrigatorio}")
    private String preco;
    @NotEmpty(message = "{campo.data.invalido}")
    private String data;
    @NotNull(message = "{campo.idCliente.invalido}")
    private Integer idCliente;

}
/*
A importancia da criação desse DTO se da pelo tratamento de dado em relação ao Cliente,
 o qual será necessario apenas o id na hora de criar ou consultar um novo ServicoPrestado

 NoArgs para criar um construtor sem parametro, ja que no RequestBody da controller será passado um JSON,
 o que obriga um construtor sem parametros no Objeto.
 */