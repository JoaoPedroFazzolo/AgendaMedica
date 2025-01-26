package com.agendamedica.service;

import com.agendamedica.entity.MedicoModel;
import com.agendamedica.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository, MedicoRepository medicoRepository) {
        this.repository = repository;
    }

    public List<MedicoModel> listar() {
        return repository.findAll();
    }

    public MedicoModel salvar(MedicoModel medico) {
        return repository.save(medico);
    }

    public Optional<MedicoModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<MedicoModel> atualizar(Long id, MedicoModel updateMedico) {
        Optional<MedicoModel> optionalMedico = repository.findById(id);
        if (optionalMedico.isPresent()) {
            MedicoModel medico = optionalMedico.get();
            medico.setNome(updateMedico.getNome());
            medico.setCpf(updateMedico.getCpf());
            medico.setEspecialidade(updateMedico.getEspecialidade());
            repository.save(medico);
            return Optional.of(medico);
        }
        return Optional.empty();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
