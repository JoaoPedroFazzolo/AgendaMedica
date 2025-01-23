package com.agendamedica.controller.response;

import lombok.Builder;

@Builder
public record FuncionarioResponse(Long id, String nome, int cpf, String funcao) {
}
