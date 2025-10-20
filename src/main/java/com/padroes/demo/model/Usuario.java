package com.padroes.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "usuario") //mappedBy Indica a relação do outro lado com a classe Avaliacao.
    private List<Avaliacao> avaliacoes;

    @ManyToMany(mappedBy = "usuario")
    private List<Obra> obras;
}
