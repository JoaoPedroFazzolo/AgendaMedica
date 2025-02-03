package com.agendamedica.controller.request;

import com.agendamedica.entity.ConsultaModel;
import jakarta.validation.constraints.NotEmpty;

public record MedicoRequest(
        @NotEmpty(message = "Nome do médico é obrigatório")
        String nome,
        @NotEmpty(message = "CPF do médico é obrigatório")
        String cpf,
        @NotEmpty(message = "Especialidade do médico é obrigatório")
        String especialidade,
        ConsultaModel consultaModel) {
}
