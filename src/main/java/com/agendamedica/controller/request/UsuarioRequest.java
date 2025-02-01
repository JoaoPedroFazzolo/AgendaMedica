package com.agendamedica.controller.request;

import com.agendamedica.entity.FuncionarioModel;
import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;
import com.agendamedica.entity.TipoUsuario;

public record UsuarioRequest(String email
        ,String senha
        , TipoUsuario tipoUsuario
        , MedicoModel medico
        , PacienteModel paciente
        , FuncionarioModel funcionario) {
}
