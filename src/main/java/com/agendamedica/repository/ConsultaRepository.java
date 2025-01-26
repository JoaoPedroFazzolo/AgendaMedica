package com.agendamedica.repository;

import com.agendamedica.entity.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaModel, Long> {

    List<ConsultaModel> findByMedicoModelIdOrderByDataConsultaDesc(Long medicoModelId);
    List<ConsultaModel> findByPacienteModelIdOrderByDataConsultaDesc(Long pacienteModelId);
    List<ConsultaModel> findByDataConsultaBetween(LocalDateTime inicio, LocalDateTime fim);
    List<ConsultaModel> findByCriadoEmBetween(LocalDateTime inicio, LocalDateTime fim);
}
