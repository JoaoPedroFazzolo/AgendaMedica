package com.agendamedica.controller.response;

import com.agendamedica.entity.ConsultaModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Builder
public record PacienteResponse(

        @Schema(type = "Long", description = "Envia o id do Paciente")
        Long id,

        @Schema(type = "String", description = "Envia o nome do Paciente")
        String nome,

        @Schema(type = "String", description = "Envia o CPF do Paciente")
        String cpf,

        @Schema(type = "String", description = "Envia o telefone do Paciente")
        String telefone,

        @Schema(type = "ConsultaModel", description = "Envia a lista de consulta do Paciente")
        List<ConsultaModel> consultaModel) {
}
