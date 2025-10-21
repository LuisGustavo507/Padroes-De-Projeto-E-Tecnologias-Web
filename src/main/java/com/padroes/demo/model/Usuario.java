package com.padroes.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 55)
    private String nome;

    @NotBlank
    @Email
    private String email;

    private String senha;
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "usuario") //mappedBy Indica a relação do outro lado com a classe Avaliacao.
    private List<Avaliacao> avaliacoes;

    @ManyToMany(mappedBy = "usuarios")
    private List<Obra> obras;
}
