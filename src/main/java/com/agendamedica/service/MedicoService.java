package com.agendamedica.service;

import com.agendamedica.entity.MedicoModel;
import com.agendamedica.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService {

    private final MedicoRepository repository;

    public List<MedicoModel> listar() {
        return repository.findAll();
    }
}
