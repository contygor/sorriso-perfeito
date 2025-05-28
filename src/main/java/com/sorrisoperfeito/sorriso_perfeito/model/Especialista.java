package com.sorrisoperfeito.sorriso_perfeito.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Especialista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobrenome;
    private String especialidade;

    @ManyToMany
    @JoinTable(
        name = "especialista_conselho",
        joinColumns = @JoinColumn(name = "especialista_id"),
        inverseJoinColumns = @JoinColumn(name = "conselho_id")
    )
    private List<ConselhoClasse> conselhos;
}