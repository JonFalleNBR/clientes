package io.github.jonfallenbr.apiclientes.model.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "login") // cada usuario criado é unico, sem poder repetir o mesmo username
    @NotEmpty(message = "{campo.login.invalido}")
    private String username;

    @Column(name = "senha")
    @NotEmpty(message = "{campo.senha.invalido}")
    private String password;
}
