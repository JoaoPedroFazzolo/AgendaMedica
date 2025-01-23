package com.agendamedica.service;

import com.agendamedica.entity.ConsultaModel;
import com.agendamedica.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public List<ConsultaModel> listar() {
        return repository.findAll();
    }
}
