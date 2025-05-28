package com.sorrisoperfeito.sorriso_perfeito.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;

@Entity
@Data
public class AgendaDeExames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "especialista_id")
    private Especialista especialista;

    private java.sql.Date data;
    private java.sql.Time hora;

    @ManyToOne
    @JoinColumn(name = "exame_id")
    private Exame exame;
}