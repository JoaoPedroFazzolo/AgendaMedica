package com.agendamedica.controller.response;

import com.agendamedica.entity.ConsultaModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Builder
public record MedicoResponse(
        @Schema(type = "Long", description = "Envia o id do Médico")
        Long id,

        @Schema(type = "String", description = "Envia o nome do Médico")
        String nome,

        @Schema(type = "String", description = "Envia o cpf do Médico")
        String cpf,

        @Schema(type = "String", description = "Envia a especialidade do Médico")
        String especialidade,

        @Schema(type = "ConsultaModel", description = "Envia a lista de consulta do Médico")
        List<ConsultaModel> consultaModels) {
}
