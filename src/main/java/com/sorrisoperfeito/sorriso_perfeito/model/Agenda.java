package com.sorrisoperfeito.sorriso_perfeito.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Especialista especialista;

    private LocalDate data;
    private LocalTime hora;
    private double preco;

    @Enumerated(EnumType.STRING)
    private TipoAgendamento tipo;

    @OneToOne(cascade = CascadeType.ALL)
    private Consulta consulta;

    @OneToOne(cascade = CascadeType.ALL)
    private Exame exame;

    public Agenda() {
    }

    public Agenda(Paciente paciente, Especialista especialista, LocalDate data, LocalTime hora, double preco, TipoAgendamento tipo, Consulta consulta, Exame exame) {
        this.paciente = paciente;
        this.especialista = especialista;
        this.data = data;
        this.hora = hora;
        this.preco = preco;
        this.tipo = tipo;
        this.consulta = consulta;
        this.exame = exame;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Especialista getEspecialista() {
        return especialista;
    }

    public void setEspecialista(Especialista especialista) {
        this.especialista = especialista;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public TipoAgendamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoAgendamento tipo) {
        this.tipo = tipo;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Exame getExame() {
        return exame;
    }

    public void setExame(Exame exame) {
        this.exame = exame;
    }
}
