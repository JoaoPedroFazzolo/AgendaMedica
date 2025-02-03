package com.agendamedica.controller.request;


import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(
        @NotEmpty(message = "email do usuario é obrigatório")
        String email,
        @NotEmpty(message = "senha do usuario é obrigatório")
        String senha) {
}
