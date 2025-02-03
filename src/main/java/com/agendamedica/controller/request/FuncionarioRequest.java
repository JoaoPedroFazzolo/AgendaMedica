package com.agendamedica.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record FuncionarioRequest(
        @NotEmpty(message = "Nome do funcionario é obrigatório")
        String nome,
        @NotEmpty(message = "CPF do funcionario é obrigatório")
        String cpf,
        @NotEmpty(message = "Funcao do funcionario é obrigatório")
        String funcao) {
}
