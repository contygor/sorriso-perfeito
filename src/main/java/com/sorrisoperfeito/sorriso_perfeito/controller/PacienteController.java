package com.sorrisoperfeito.sorriso_perfeito.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sorrisoperfeito.sorriso_perfeito.model.Paciente;
import com.sorrisoperfeito.sorriso_perfeito.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listarTodos() {
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Long id) {
        Optional<Paciente> paciente = pacienteService.listarPacientePeloID(id);
        return paciente.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Paciente cadastrar(@RequestBody Paciente paciente) {
        return pacienteService.salvarPaciente(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> atualizar(@PathVariable Long id, @RequestBody Paciente paciente) {
        Optional<Paciente> atualizado = pacienteService.atualizarPaciente(id, paciente);
        return atualizado.map(ResponseEntity::ok)
                         .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (pacienteService.deletarPaciente(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

