package com.agendamedica.controller.response;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginResponse(

        @Schema(type = "String", description = "Envia o token de autenticacao")
        String token) {
}
