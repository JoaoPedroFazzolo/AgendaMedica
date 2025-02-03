package com.agendamedica.controller.response;

import com.agendamedica.entity.ConsultaModel;
import lombok.Builder;

import java.util.List;

@Builder
public record MedicoResponse(Long id, String nome, String cpf, String especialidade, List<ConsultaModel> consultaModels) {
}
