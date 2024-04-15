package io.github.jonfallenbr.apiclientes.model.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, name = "login") // cada usuario criado é unico, sem poder repetir o mesmo username
    private String username;

    @Column(name = "senha")
    private String password;
}
