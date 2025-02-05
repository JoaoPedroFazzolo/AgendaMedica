package com.agendamedica.service;

import com.agendamedica.entity.PacienteModel;
import com.agendamedica.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PacienteService {

    private final PacienteRepository repository;

    public List<PacienteModel> listar() {
        log.info("Listando pacientes");
        return repository.findAll();
    }

    public PacienteModel salvar(PacienteModel pacienteModel) {
        log.info("Salvando paciente {}", pacienteModel);
        return repository.save(pacienteModel);
    }

    public Optional<PacienteModel> buscarPorId(Long id) {
        log.info("Buscando paciente {}", id);
        return repository.findById(id);
    }

    public void excluir(Long id) {
        log.info("Excluindo paciente {}", id);
        repository.deleteById(id);
    }

    public Optional<PacienteModel> atualizar(Long id, PacienteModel updatePaciente) {
        Optional<PacienteModel> optionalPaciente = repository.findById(id);
        log.info("Atualizando paciente {}", updatePaciente);
        if (optionalPaciente.isPresent()) {
            PacienteModel paciente = optionalPaciente.get();
            paciente.setNome(updatePaciente.getNome());
            paciente.setCpf(updatePaciente.getCpf());
            paciente.setTelefone(updatePaciente.getTelefone());
            repository.save(paciente);
            log.info("Paciente atualizado com sucesso");
            return Optional.of(paciente);
        }
        log.info("Paciente nao encontrado");
        return Optional.empty();
    }
}

