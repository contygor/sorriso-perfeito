package com.sorrisoperfeito.sorriso_perfeito.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sorrisoperfeito.sorriso_perfeito.model.Paciente;
import com.sorrisoperfeito.sorriso_perfeito.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public Optional<Paciente> listarPacientePeloID(Long id) {
        return pacienteRepository.findById(id);
    }

    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> atualizarPaciente(Long id, Paciente pacienteAtualizado) {
        return pacienteRepository.findById(id).map(pacienteExistente -> {
            pacienteExistente.setNome(pacienteAtualizado.getNome());
            pacienteExistente.setSobrenome(pacienteAtualizado.getSobrenome());
            pacienteExistente.setEmail(pacienteAtualizado.getEmail());
            pacienteExistente.setNascimento(pacienteAtualizado.getNascimento());
            pacienteExistente.setCpf(pacienteAtualizado.getCpf());
            pacienteExistente.setOcupacao(pacienteAtualizado.getOcupacao());
            pacienteExistente.setTelefone(pacienteAtualizado.getTelefone());
            pacienteExistente.setEndereco(pacienteAtualizado.getEndereco());
            pacienteExistente.setPlanos(pacienteAtualizado.getPlanos());
            return pacienteRepository.save(pacienteExistente);
        });
    }

    public boolean deletarPaciente(Long id) {
        return pacienteRepository.findById(id).map(paciente -> {
            pacienteRepository.delete(paciente);
            return true;
        }).orElse(false);
    }
}

