package com.agendamedica.service;

import com.agendamedica.entity.ConsultaModel;
import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;
import com.agendamedica.repository.ConsultaRepository;
import com.agendamedica.repository.MedicoRepository;
import com.agendamedica.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ConsultaService {

    private final ConsultaRepository repository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    public List<ConsultaModel> listar() {
        log.info("Listando todas as consultas");
        return repository.findAll();
    }

    public List<ConsultaModel> buscaPorMedico(Long id){
        log.info("Buscando consultas do medico de ID {}", id);
        log.info("Consultas encontradas");
        return repository.findByMedicoModelIdOrderByDataConsultaDesc(id);
    }

    public List<ConsultaModel> buscaPorPaciente(Long id){
        log.info("Buscando consultas do paciente de ID {}", id);
        log.info("Consultas encontradas");
        return repository.findByPacienteModelIdOrderByDataConsultaDesc(id);
    }

    public List<ConsultaModel> buscaPorDataDaConsulta(LocalDate data){
        log.info("Buscando consultas agendadas para a data {}", data);
        log.info("Consultas encontradas");
        LocalDateTime inicioDoDia = data.atStartOfDay();
        LocalDateTime fimDoDia = data.atTime(23, 59, 59);
        return repository.findByDataConsultaBetween(inicioDoDia, fimDoDia);
    }

    public List<ConsultaModel> buscaPorDataDaCriacaoConsulta(LocalDate data){
        log.info("Buscando consultas agendadas na data {}", data);
        log.info("Consultas encontradas");
        LocalDateTime inicioDoDia = data.atStartOfDay();
        LocalDateTime fimDoDia = data.atTime(23, 59, 59);
        return repository.findByCriadoEmBetween(inicioDoDia, fimDoDia);
    }

    public ConsultaModel salvar(ConsultaModel consulta) {
        log.info("Salvando {}", consulta);
        if (consulta.getMedicoModel() != null && consulta.getPacienteModel() != null) {
            Optional<MedicoModel> medico = medicoRepository.findById(consulta.getMedicoModel().getId());
            Optional<PacienteModel> paciente = pacienteRepository.findById(consulta.getPacienteModel().getId());
            if (medico.isPresent() && paciente.isPresent()) {
                consulta.setMedicoModel(medico.get());
                consulta.setPacienteModel(paciente.get());
                log.info("Consulta salvo com sucesso");
            }
        }
        return repository.save(consulta);
    }

    public Optional<ConsultaModel> buscarPorId(Long id) {
        log.info("Buscando consulta para ID {}", id);
        return repository.findById(id);
    }

    public Optional<ConsultaModel> atualizar(Long id, ConsultaModel updateConsulta) {
        log.info("Atualizando a consulta{}", updateConsulta);
        Optional<ConsultaModel> optionalConsulta = repository.findById(id);
        if (optionalConsulta.isPresent()) {
            ConsultaModel consulta = optionalConsulta.get();
            consulta.setMedicoModel(updateConsulta.getMedicoModel());
            consulta.setPacienteModel(updateConsulta.getPacienteModel());
            consulta.setDataConsulta(updateConsulta.getDataConsulta());
            repository.save(consulta);
            log.info("Consulta atualizada com sucesso");
            return Optional.of(consulta);
        }
        return Optional.empty();
    }

    public void excluir(Long id) {
        log.info("Excluindo a consulta de ID{}", id);
        repository.deleteById(id);
    }


}
