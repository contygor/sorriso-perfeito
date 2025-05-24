package com.sorrisoperfeito.sorriso_perfeito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sorrisoperfeito.sorriso_perfeito.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
