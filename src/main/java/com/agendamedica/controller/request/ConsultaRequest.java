package com.agendamedica.controller.request;

import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;


public record ConsultaRequest(@NotEmpty(message = "Médico é obrigatório")
                              MedicoModel medicoModel,
                              @NotEmpty(message = "Paciente é obrigatório")
                              PacienteModel pacienteModel,
                              @NotEmpty(message = "Data e hora da consulta são obrigatórios")
                              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy'T'HH:mm")
                              LocalDateTime dataConsulta,
                              @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy'T'HH:mm:ss")
                              LocalDateTime criadoEm){}
