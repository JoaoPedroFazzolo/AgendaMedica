package com.agendamedica.controller.response;

import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ConsultaResponse(
        @Schema(type = "Long", description = "Envia o id da consulta")
        Long id,

        @Schema(type = "MedicoModel", description = "Envia as informacoes do Medico")
        MedicoModel medicoModel,

        @Schema(type = "PacienteModel", description = "Envia as informacoes do Paciente")
        PacienteModel pacienteModel,

        @Schema(type = "LocalDateTime", description = "Envia as informacoes de data e hora da consulta")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy'T'HH:mm")
        LocalDateTime dataConsulta,

        @Schema(type = "LocalDateTime", description = "Envia as informacoes de data e hora de criacao da consulta")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy'T'HH:mm:ss")
        LocalDateTime criadoEm) {
}
