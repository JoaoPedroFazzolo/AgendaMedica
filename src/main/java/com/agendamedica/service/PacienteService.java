package com.agendamedica.service;

import com.agendamedica.entity.PacienteModel;
import com.agendamedica.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(com.agendamedica.repository.PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public List<PacienteModel> listar() {
        return pacienteRepository.findAll();
    }

    public PacienteModel salvar(PacienteModel pacienteModel) {
        return pacienteRepository.save(pacienteModel);
    }

    public Optional<PacienteModel> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    public void excluir(Long id) {
        pacienteRepository.deleteById(id);
    }
}
