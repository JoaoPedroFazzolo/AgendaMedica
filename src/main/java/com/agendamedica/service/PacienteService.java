package com.agendamedica.service;

import com.agendamedica.entity.PacienteModel;
import com.agendamedica.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository PacienteRepository;

    public List<PacienteModel> listar() {
        return PacienteRepository.findAll();
    }
}
