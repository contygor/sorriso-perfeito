package com.sorrisoperfeito.sorriso_perfeito.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    private String nome;
    private String sobrenome;
    private String email;
    private java.sql.Date nascimento;
    private String cpf;
    private String ocupacao;
    private String telefone;

    @ManyToMany
    @JoinTable(
        name = "paciente_plano",
        joinColumns = @JoinColumn(name = "paciente_id"),
        inverseJoinColumns = @JoinColumn(name = "plano_id")
    )
    private List<PlanoDeSaude> planos;
}