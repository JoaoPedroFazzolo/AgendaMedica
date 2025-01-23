package com.agendamedica.controller.response;

import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ConsultaResponse(Long id, MedicoModel medicoModel, PacienteModel pacienteModel, LocalDateTime dataConsulta) {
}
