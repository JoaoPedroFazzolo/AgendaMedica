package com.agendamedica.controller.response;

import com.agendamedica.entity.FuncionarioModel;
import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;
import com.agendamedica.entity.TipoUsuario;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record UsuarioResponse(
        @Schema(type = "Long", description = "Envia o id do Usuario")
        Long id,

        @Schema(type = "String", description = "Envia o email do Usuario")
        String email,

        @Schema(type = "TipoUsuario", description = "Envia o tipo de Usuario")
        TipoUsuario tipoUsuario,

        @Schema(type = "MedicoModel", description = "Envia as informacoes do Medico")
        MedicoModel medicoId,

        @Schema(type = "PacienteModel", description = "Envia as informacoes do Paciente")
        PacienteModel pacienteId,

        @Schema(type = "FuncionarioModel", description = "Envia as informacoes do Funcionario")
        FuncionarioModel funcionarioId
) {}


