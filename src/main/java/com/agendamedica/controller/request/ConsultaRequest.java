package com.agendamedica.controller.request;

import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ConsultaRequest(MedicoModel medicoModel,
                              PacienteModel pacienteModel,
                              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy'T'HH:mm")
                              LocalDateTime dataConsulta,
                              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy'T'HH:mm:ss")
                              LocalDateTime criadoEm) {
}
