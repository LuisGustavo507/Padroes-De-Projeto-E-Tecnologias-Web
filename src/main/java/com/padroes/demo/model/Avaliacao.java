package com.padroes.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int nota;
    private String comentario;
    private LocalDateTime dataAvaliacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")//Define a chave fk
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;


}
