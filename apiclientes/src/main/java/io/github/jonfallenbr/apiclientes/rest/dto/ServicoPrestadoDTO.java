package io.github.jonfallenbr.apiclientes.rest.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ServicoPrestadoDTO {
    private String descricao;
    private String preco;
    private String data;
    private Integer idCliente;

}
/*
A importancia da criação desse DTO se da pelo tratamento de dado em relação ao Cliente,
 o qual será necessario apenas o id na hora de criar ou consultar um novo ServicoPrestado

 NoArgs para criar um construtor sem parametro, ja que no RequestBody da controller será passado um JSON,
 o que obriga um construtor sem parametros no Objeto.
 */