package com.agendamedica.controller.request;

import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;


public record ConsultaRequest(

        @Schema(type = "MedicoModel", description = "Recebe as informacoes do medico")
        @NotEmpty(message = "Médico é obrigatório")
        MedicoModel medicoModel,

        @Schema(type = "PacienteModel", description = "Recebe as informacoes do paciente")
        @NotEmpty(message = "Paciente é obrigatório")
        PacienteModel pacienteModel,

        @Schema(type = "LocalDateTime", description = "Recebe a data e hora da consulta")
        @NotEmpty(message = "Data e hora da consulta são obrigatórios")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy'T'HH:mm")
        LocalDateTime dataConsulta,

        @Schema(type = "LocalDateTime", description = "Recebe a data e hora de criacao da consulta")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy'T'HH:mm:ss")
        LocalDateTime criadoEm){}
