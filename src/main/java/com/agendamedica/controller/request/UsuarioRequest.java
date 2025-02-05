package com.agendamedica.controller.request;

import com.agendamedica.entity.FuncionarioModel;
import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;
import com.agendamedica.entity.TipoUsuario;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

public record UsuarioRequest(
        @Schema(type = "String", description = "Email do Usuario")
        @NotEmpty(message = "Email do usuario é obrigatório")
        String email,

        @Schema(type = "String", description = "Senha do Usuario")
        @NotEmpty(message = "Senha do usuario é obrigatório")
        String senha,

        @Schema(type = "String", description = "Informa o tipo de Usuario")
        @NotEmpty(message = "Tipo do usuario é obrigatório")
        TipoUsuario tipoUsuario,

        @Schema(type = "MedicoModel", description = "Recebe as informacoes da classe MedicoModel caso o Usuario seja dessa classe")
        MedicoModel medico,

        @Schema(type = "PacienteModel", description = "Recebe as informacoes da classe PacienteModel caso o Usuario seja dessa classe")
        PacienteModel paciente,

        @Schema(type = "FuncionarioModel", description = "Recebe as informacoes da classe FuncionarioModel caso o Usuario seja dessa classe")
        FuncionarioModel funcionario) {
}
