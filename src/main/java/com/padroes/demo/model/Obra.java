package com.padroes.demo.model;

import com.padroes.demo.enums.Tipo;
import jakarta.persistence.*;

import java.util.List;

public class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private int anoLancamento;
    private Enum<Tipo> tipo;
    private String imagemUrl;

    @ManyToMany
    //@JoinTable serve para configurar uma tebelas intermediaria quando for relação N:N
    @JoinTable(
            name = "Favorito",
            joinColumns = @JoinColumn(name = "obra_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")//inverseJoinColumns referencia a entidade oposta
    )
    private List<Usuario> usuarios;

    @ManyToMany
    @JoinTable(
            name = "obra_genero",
            joinColumns = @JoinColumn(name = "obra_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")//inverseJoinColumns referencia a entidade oposta
    )
    private List<Genero> generos;

    @OneToMany(mappedBy = "obra")
    private List<Avaliacao> avaliacoess;
}



