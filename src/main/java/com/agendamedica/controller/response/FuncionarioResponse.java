package com.agendamedica.controller.response;

import lombok.Builder;

@Builder
public record FuncionarioResponse(Long id, String nome, String cpf, String funcao) {
}
