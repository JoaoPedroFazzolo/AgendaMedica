package com.agendamedica.controller.mapper;

import com.agendamedica.controller.request.UsuarioRequest;
import com.agendamedica.controller.response.UsuarioResponse;
import com.agendamedica.entity.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsuarioMapper {

    public static UsuarioModel toUsuario(UsuarioRequest request) {
        MedicoModel medico = null;
        PacienteModel paciente = null;
        FuncionarioModel funcionario = null;
        if (TipoUsuario.MEDICO.equals(request.tipoUsuario())) {
            medico = MedicoModel.builder()
                    .nome(request.medico().getNome())
                    .cpf(request.medico().getCpf())
                    .especialidade(request.medico().getEspecialidade()).build();
        } else if (TipoUsuario.PACIENTE.equals(request.tipoUsuario())) {
            paciente = PacienteModel.builder()
                    .nome(request.paciente().getNome())
                    .cpf(request.paciente().getCpf())
                    .telefone(request.paciente().getTelefone()).build();
        } else if (TipoUsuario.FUNCIONARIO.equals(request.tipoUsuario())) {
            funcionario = FuncionarioModel.builder()
                    .nome(request.funcionario().getNome())
                    .cpf(request.funcionario().getCpf())
                    .funcao(request.funcionario().getFuncao()).build();
        }

        return UsuarioModel.builder()
                .email(request.email())
                .senha(request.senha())
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
                .medicoId(usuario.getMedico() != null ? usuario.getMedico() : null)
                .pacienteId(usuario.getPaciente() != null ? usuario.getPaciente() : null)
                .funcionarioId(usuario.getFuncionario() != null ? usuario.getFuncionario() : null)
                .build();
    }

}