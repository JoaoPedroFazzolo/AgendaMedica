package com.agendamedica.controller.mapper;

import com.agendamedica.controller.request.UsuarioRequest;
import com.agendamedica.controller.response.UsuarioResponse;
import com.agendamedica.entity.FuncionarioModel;
import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;
import com.agendamedica.entity.UsuarioModel;

public class UsuarioMapper {

    public static UsuarioModel toUsuario(UsuarioRequest request) {
        MedicoModel medico = null;
        PacienteModel paciente = null;
        FuncionarioModel funcionario = null;
        if ("MEDICO".equals(request.tipoUsuario())) {
            medico = new MedicoModel();
        } else if ("PACIENTE".equals(request.tipoUsuario())) {
            paciente = new PacienteModel();
        } else if ("FUNCIONARIO".equals(request.tipoUsuario())) {
            funcionario = new FuncionarioModel();
        }

        return UsuarioModel.builder()
                .email(request.email())
                .senha(request.senha()) // Idealmente, a senha deve ser encriptada antes de salvar
                .tipoUsuario(request.tipoUsuario())
                .medico(medico)
                .paciente(paciente)
                .funcionario(funcionario)
                .build();
    }


    public static UsuarioResponse toUsuarioResponse(UsuarioModel usuario) {
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .email(usuario.getEmail())
                .tipoUsuario(usuario.getTipoUsuario())
                .medicoId(usuario.getMedico() != null ? usuario.getMedico().getId() : null)
                .pacienteId(usuario.getPaciente() != null ? usuario.getPaciente().getId() : null)
                .funcionarioId(usuario.getFuncionario() != null ? usuario.getFuncionario().getId() : null)
                .build();
    }

}