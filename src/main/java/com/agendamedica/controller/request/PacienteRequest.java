package com.agendamedica.controller.request;

import com.agendamedica.entity.ConsultaModel;

public record PacienteRequest(String nome, String cpf, String telefone, ConsultaModel consultaModel) {
}
