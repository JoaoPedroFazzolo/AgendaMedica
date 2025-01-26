package com.agendamedica.service;

import com.agendamedica.entity.ConsultaModel;
import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;
import com.agendamedica.repository.ConsultaRepository;
import com.agendamedica.repository.MedicoRepository;
import com.agendamedica.repository.PacienteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ConsultaService {

    private final ConsultaRepository repository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    public ConsultaService(ConsultaRepository repository, MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
        this.repository = repository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public List<ConsultaModel> listar() {
        return repository.findAll();
    }

    public ConsultaModel salvar(ConsultaModel consulta) {
        if (consulta.getMedicoModel() != null && consulta.getPacienteModel() != null) {
            Optional<MedicoModel> medico = medicoRepository.findById(consulta.getMedicoModel().getId());
            Optional<PacienteModel> paciente = pacienteRepository.findById(consulta.getPacienteModel().getId());
            if (medico.isPresent() && paciente.isPresent()) {
                consulta.setMedicoModel(medico.get());
                consulta.setPacienteModel(paciente.get());
            }
        }
        return repository.save(consulta);
    }

    public Optional<ConsultaModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<ConsultaModel> atualizar(Long id, ConsultaModel updateConsulta) {
        Optional<ConsultaModel> optionalConsulta = repository.findById(id);
        if (optionalConsulta.isPresent()) {
            ConsultaModel consulta = optionalConsulta.get();
            consulta.setMedicoModel(updateConsulta.getMedicoModel());
            consulta.setPacienteModel(updateConsulta.getPacienteModel());
            consulta.setDataConsulta(updateConsulta.getDataConsulta());
            repository.save(consulta);
            return Optional.of(consulta);
        }
        return Optional.empty();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }


}
