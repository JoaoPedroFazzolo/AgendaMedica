package com.agendamedica.controller.request;

import com.agendamedica.entity.ConsultaModel;

public record MedicoRequest(String nome, String cpf, String especialidade, ConsultaModel consultaModel) {
}
