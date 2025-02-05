package com.agendamedica.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
public record FuncionarioResponse(

        @Schema(type = "Long", description = "Envia o id do Funcionario")
        Long id,

        @Schema(type = "String", description = "Envia o nome do Funcionario")
        String nome,

        @Schema(type = "String", description = "Envia o CPF do Funcionario")
        String cpf,

        @Schema(type = "String", description = "Envia a funcao do Funcionario")
        String funcao) {
}
