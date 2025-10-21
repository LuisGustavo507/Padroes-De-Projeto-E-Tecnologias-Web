package com.padroes.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Max(value = 10)
    private int nota;

    @NotBlank
    @Size(min = 5, max = 255)
    private String comentario;
    private LocalDateTime dataAvaliacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")//Define a chave fk
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "obra_id")
    private Obra obra;


}
