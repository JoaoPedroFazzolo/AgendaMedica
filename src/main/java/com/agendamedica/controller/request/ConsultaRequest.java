package com.agendamedica.controller.request;

import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;

import java.time.LocalDateTime;

public record ConsultaRequest(MedicoModel medicoModel, PacienteModel pacienteModel, LocalDateTime dataConsulta, LocalDateTime criadoEm) {
}
