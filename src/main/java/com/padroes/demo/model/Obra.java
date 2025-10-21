package com.padroes.demo.model;

import com.padroes.demo.enums.Tipo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Obra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 155)
    private String titulo;

    @NotBlank
    @Size(min = 5, max = 255)
    private String descricao;

    @Min(value = 1000)
    private int anoLancamento;

    private Enum<Tipo> tipo;
    private String imagemUrl;

    @ManyToMany
    //@JoinTable serve para configurar uma tebela intermediaria quando for relação N:N
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



