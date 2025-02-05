package com.agendamedica.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record FuncionarioRequest(

        @Schema(type = "String", description = "Nome do funcionario")
        @NotEmpty(message = "Nome do funcionario é obrigatório")
        String nome,

        @Schema(type = "String", description = "CPF do paciente com 11 caracteres, apenas numeros")
        @NotEmpty(message = "CPF do funcionario é obrigatório")
        String cpf,

        @Schema(type = "String", description = "Funcao do funcionario")
        @NotEmpty(message = "Funcao do funcionario é obrigatório")
        String funcao) {
}
