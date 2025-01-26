package com.agendamedica.service;

import com.agendamedica.entity.PacienteModel;
import com.agendamedica.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(com.agendamedica.repository.PacienteRepository repository) {
        this.repository = repository;
    }

    public List<PacienteModel> listar() {
        return repository.findAll();
    }

    public PacienteModel salvar(PacienteModel pacienteModel) {
        return repository.save(pacienteModel);
    }

    public Optional<PacienteModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public Optional<PacienteModel> atualizar(Long id, PacienteModel updatePaciente) {
        Optional<PacienteModel> optionalPaciente = repository.findById(id);
        if (optionalPaciente.isPresent()) {
            PacienteModel paciente = optionalPaciente.get();
            paciente.setNome(updatePaciente.getNome());
            paciente.setCpf(updatePaciente.getCpf());
            paciente.setTelefone(updatePaciente.getTelefone());
            repository.save(paciente);
            return Optional.of(paciente);
        }
        return Optional.empty();
    }
}

