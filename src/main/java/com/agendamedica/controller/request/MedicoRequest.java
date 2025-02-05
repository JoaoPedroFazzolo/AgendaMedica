package com.agendamedica.controller.request;

import com.agendamedica.entity.ConsultaModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record MedicoRequest(
        @Schema(type = "String", description = "Nome do médico")
        @NotEmpty(message = "Nome do médico é obrigatório")
        String nome,

        @Schema(type = "String", description = "CPF do medico com 11 caracteres, apenas numeros")
        @NotEmpty(message = "CPF do médico é obrigatório")
        String cpf,

        @Schema(type = "String", description = "especialidade do médico")
        @NotEmpty(message = "Especialidade do médico é obrigatório")
        String especialidade,

        @Schema(type = "ConsultaModel", description = "Recebe as informacoes de consulta do medico")
        ConsultaModel consultaModel) {
}
