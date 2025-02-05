package com.agendamedica.controller.request;

import com.agendamedica.entity.ConsultaModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record PacienteRequest(
        @Schema(type = "String", description = "Nome do paciente")
        @NotEmpty(message = "Nome do paciente é obrigatório")
        String nome,

        @Schema(type = "cpf", description = "CPF do paciente com 11 caracteres, apenas numeros")
        @NotEmpty(message = "CPF do paciente é obrigatório")
        String cpf,

        @Schema(type = "String", description = "Telefone do paciente, apenas numeros")
        @NotEmpty(message = "Telefone do paciente é obrigatório")
        String telefone,

        @Schema(type = "ConsultaModel", description = "Recebe as informacoes de consulta do paciente")
        ConsultaModel consultaModel) {
}
