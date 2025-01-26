package com.agendamedica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionario")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "funcao", length = 100, nullable = false)
    private String funcao;

    @OneToOne(mappedBy = "funcionario")
    private UsuarioModel usuarioModel;

    public FuncionarioModel() {
    }

    public FuncionarioModel(long id, String nome, String cpf, String funcao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.funcao = funcao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long id;
        private String nome;
        private String cpf;
        private String funcao;

        public Builder id(long id) {
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

        public FuncionarioModel build() {
            return new FuncionarioModel(id, nome, cpf, funcao);
        }
    }
}
