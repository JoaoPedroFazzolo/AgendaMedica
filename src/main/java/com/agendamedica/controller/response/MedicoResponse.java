package com.agendamedica.controller.response;

import com.agendamedica.entity.ConsultaModel;

import java.util.List;

public record MedicoResponse(Long id, String nome, String cpf, String especialidade, List<ConsultaModel> consultaModels) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String nome;
        private String cpf;
        private String especialidade;
        private List<ConsultaModel> consultaModels;  // Change to List<ConsultaModel>

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

        public Builder especialidade(String especialidade) {
            this.especialidade = especialidade;
            return this;
        }

        public Builder consultaModels(List<ConsultaModel> consultaModels) {  // Change to List<ConsultaModel>
            this.consultaModels = consultaModels;
            return this;
        }

        public MedicoResponse build() {
            return new MedicoResponse(id, nome, cpf, especialidade, consultaModels);  // No cast needed
        }
    }
}
