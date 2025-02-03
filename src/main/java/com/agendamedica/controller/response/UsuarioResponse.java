package com.agendamedica.controller.response;

import com.agendamedica.entity.FuncionarioModel;
import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;
import com.agendamedica.entity.TipoUsuario;
import lombok.Builder;

@Builder
public record UsuarioResponse(
        Long id,
        String email,
        TipoUsuario tipoUsuario,
        MedicoModel medicoId,
        PacienteModel pacienteId,
        FuncionarioModel funcionarioId
) {}


