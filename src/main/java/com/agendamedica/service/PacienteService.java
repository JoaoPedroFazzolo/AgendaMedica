package com.agendamedica.service;

import com.agendamedica.entity.PacienteModel;
import com.agendamedica.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository PacienteRepository;

    public PacienteService(com.agendamedica.repository.PacienteRepository pacienteRepository) {
        PacienteRepository = pacienteRepository;
    }

    public List<PacienteModel> listar() {
        return PacienteRepository.findAll();
    }

    public PacienteModel salvar(PacienteModel pacienteModel) {
        return PacienteRepository.save(pacienteModel);
    }
}
