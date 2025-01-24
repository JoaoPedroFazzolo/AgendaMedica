package com.agendamedica.controller.response;

import com.agendamedica.entity.ConsultaModel;

import java.util.List;

public record PacienteResponse(Long id, String nome, String cpf, String telefone, List<ConsultaModel> consultaModel) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String nome;
        private String cpf;
        private String telefone;
        private List<ConsultaModel> consultaModel;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder telefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder consultaModel(List<ConsultaModel> consultaModel) {
            this.consultaModel = consultaModel;
            return this;
        }

        public PacienteResponse build() {
            return new PacienteResponse(id, nome, cpf, telefone, consultaModel);
        }
    }
}
