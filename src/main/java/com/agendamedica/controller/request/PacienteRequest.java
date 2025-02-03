package com.agendamedica.controller.request;

import com.agendamedica.entity.ConsultaModel;
import jakarta.validation.constraints.NotEmpty;

public record PacienteRequest(
        @NotEmpty(message = "Nome do paciente é obrigatório")
        String nome,
        @NotEmpty(message = "CPF do paciente é obrigatório")
        String cpf,
        @NotEmpty(message = "Telefone do paciente é obrigatório")
        String telefone,
        ConsultaModel consultaModel) {
}
