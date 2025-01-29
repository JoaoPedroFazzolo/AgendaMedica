package com.agendamedica.controller.request;

import com.agendamedica.entity.TipoUsuario;

public record UsuarioRequest(String email, String senha, TipoUsuario tipoUsuario, Long medicoId, Long pacienteId, Long funcionarioId) {
}
