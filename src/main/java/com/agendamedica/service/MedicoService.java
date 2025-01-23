package com.agendamedica.service;

import com.agendamedica.entity.MedicoModel;
import com.agendamedica.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public List<MedicoModel> listar() {
        return repository.findAll();
    }

    public MedicoModel salvar(MedicoModel medico) {
        return repository.save(medico);
    }
}
