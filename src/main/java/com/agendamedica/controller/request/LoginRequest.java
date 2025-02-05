package com.agendamedica.controller.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(
        @Schema(type = "String", description = "Email do usuario")
        @NotEmpty(message = "Email do usuario é obrigatório")
        String email,

        @Schema(type = "String", description = "Senha do usuario")
        @NotEmpty(message = "Senha do usuario é obrigatório")
        String senha) {
}
