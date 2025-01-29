package com.agendamedica.controller.response;

import com.agendamedica.entity.TipoUsuario;

public record UsuarioResponse(
        Long id,
        String email,
        TipoUsuario tipoUsuario,
        Long medicoId,
        Long pacienteId,
        Long funcionarioId
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String email;
        private TipoUsuario tipoUsuario;
        private Long medicoId;
        private Long pacienteId;
        private Long funcionarioId;

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

        public Builder medicoId(Long medicoId) {
            this.medicoId = medicoId;
            return this;
        }

        public Builder pacienteId(Long pacienteId) {
            this.pacienteId = pacienteId;
            return this;
        }

        public Builder funcionarioId(Long funcionarioId) {
            this.funcionarioId = funcionarioId;
            return this;
        }

        public UsuarioResponse build() {
            return new UsuarioResponse(id, email, tipoUsuario, medicoId, pacienteId, funcionarioId);
        }
    }
}


