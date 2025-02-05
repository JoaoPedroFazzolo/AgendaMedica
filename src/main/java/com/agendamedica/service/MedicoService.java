package com.agendamedica.service;

import com.agendamedica.entity.MedicoModel;
import com.agendamedica.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MedicoService {

    private final MedicoRepository repository;

    public List<MedicoModel> listar() {
        log.info("Listando todos os medicos");
        return repository.findAll();
    }

    public MedicoModel salvar(MedicoModel medico) {
        log.info("Salvando medico: {}", medico);
        return repository.save(medico);
    }

    public Optional<MedicoModel> buscarPorId(Long id) {
        log.info("Buscando medico: {}", id);
        return repository.findById(id);
    }

    public Optional<MedicoModel> atualizar(Long id, MedicoModel updateMedico) {
        Optional<MedicoModel> optionalMedico = repository.findById(id);
        log.info("Atualizando medico: {}", updateMedico);
        if (optionalMedico.isPresent()) {
            MedicoModel medico = optionalMedico.get();
            medico.setNome(updateMedico.getNome());
            medico.setCpf(updateMedico.getCpf());
            medico.setEspecialidade(updateMedico.getEspecialidade());
            repository.save(medico);
            log.info("Medico atualizado com sucesso");
            return Optional.of(medico);
        }
        log.info("Medico nao encontrado");
        return Optional.empty();
    }

    public void excluir(Long id) {
        log.info("Excluindo medico: {}", id);
        repository.deleteById(id);
    }
}
