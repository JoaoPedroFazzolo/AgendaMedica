package com.agendamedica.controller.request;

import com.agendamedica.entity.FuncionarioModel;
import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;
import com.agendamedica.entity.TipoUsuario;
import jakarta.validation.constraints.NotEmpty;

public record UsuarioRequest(
        @NotEmpty(message = "email do usuario é obrigatório")
        String email,
        @NotEmpty(message = "senha do usuario é obrigatório")
        String senha,
        @NotEmpty(message = "tipo do usuario é obrigatório")
        TipoUsuario tipoUsuario,
        MedicoModel medico,
        PacienteModel paciente,
        FuncionarioModel funcionario) {
}
