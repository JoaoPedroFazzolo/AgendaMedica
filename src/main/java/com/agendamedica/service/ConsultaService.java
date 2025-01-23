package com.agendamedica.service;

import com.agendamedica.entity.ConsultaModel;
import com.agendamedica.repository.ConsultaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public List<ConsultaModel> listar() {
        return repository.findAll();
    }

    public ConsultaModel salvar(ConsultaModel consulta) {
        return repository.save(consulta);
    }

    public Optional<ConsultaModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
