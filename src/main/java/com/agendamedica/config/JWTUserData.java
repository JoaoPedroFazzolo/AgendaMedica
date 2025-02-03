package com.agendamedica.config;

import com.agendamedica.entity.TipoUsuario;
import lombok.Builder;

@Builder
public record JWTUserData(Long id, String email, TipoUsuario tipoUsuario) {
}
