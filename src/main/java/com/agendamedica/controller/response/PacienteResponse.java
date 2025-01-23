package com.agendamedica.controller.response;

import com.agendamedica.entity.ConsultaModel;
import lombok.Builder;

@Builder
public record PacienteResponse(Long id, String nome, String cpf, String telefone, ConsultaModel consultaModel) {
}
