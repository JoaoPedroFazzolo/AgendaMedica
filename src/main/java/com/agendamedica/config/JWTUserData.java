package com.agendamedica.config;

import com.agendamedica.entity.TipoUsuario;

public record JWTUserData(Long id, String email, TipoUsuario tipoUsuario) {

    public static class Builder {
        private Long id;
        private String email;
        private TipoUsuario tipoUsuario;

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

        public JWTUserData build() {
            return new JWTUserData(id, email, tipoUsuario);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
