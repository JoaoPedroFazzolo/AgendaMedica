package com.agendamedica.controller.response;

import com.agendamedica.entity.ConsultaModel;
import lombok.Builder;

import java.util.List;

@Builder
public record PacienteResponse(
        Long id,
        String nome,
        String cpf,
        String telefone,
        List<ConsultaModel> consultaModel) {
}
