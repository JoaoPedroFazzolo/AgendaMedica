package com.agendamedica.controller.response;

import com.agendamedica.entity.FuncionarioModel;
import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;
import com.agendamedica.entity.TipoUsuario;

public record UsuarioResponse(
        Long id,
        String email,
        TipoUsuario tipoUsuario,
        MedicoModel medicoId,
        PacienteModel pacienteId,
        FuncionarioModel funcionarioId
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String email;
        private TipoUsuario tipoUsuario;
        private MedicoModel medico;
        private PacienteModel paciente;
        private FuncionarioModel funcionario;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder tipoUsuario(TipoUsuario tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
            return this;
        }

        public Builder medicoId(MedicoModel medico) {
            this.medico = medico;
            return this;
        }

        public Builder pacienteId(PacienteModel paciente) {
            this.paciente = paciente;
            return this;
        }

        public Builder funcionarioId(FuncionarioModel funcionario) {
            this.funcionario = funcionario;
            return this;
        }

        public UsuarioResponse build() {
            return new UsuarioResponse(id, email, tipoUsuario, medico, paciente, funcionario);
        }
    }
}


