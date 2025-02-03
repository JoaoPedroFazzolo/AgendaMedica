package com.agendamedica.controller.response;

import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ConsultaResponse(Long id, MedicoModel medicoModel,
                               PacienteModel pacienteModel,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy'T'HH:mm")
                               LocalDateTime dataConsulta,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy'T'HH:mm:ss")
                               LocalDateTime criadoEm) {
}
