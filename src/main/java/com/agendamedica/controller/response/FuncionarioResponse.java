package com.agendamedica.controller.response;

public record FuncionarioResponse(Long id, String nome, String cpf, String funcao) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String nome;
        private String cpf;
        private String funcao;

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

        public Builder funcao(String funcao) {
            this.funcao = funcao;
            return this;
        }

        public FuncionarioResponse build() {
            return new FuncionarioResponse(id, nome, cpf, funcao);
        }
    }
}
