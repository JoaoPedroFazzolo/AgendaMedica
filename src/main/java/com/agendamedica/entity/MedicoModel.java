package com.agendamedica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "medico")
public class MedicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "especialidade", length = 100, nullable = false)
    private String especialidade;

    @OneToMany(mappedBy = "id")
    @JsonIgnore
    private List<ConsultaModel> consultaModels;

    @OneToOne(mappedBy = "medico")
    private UsuarioModel usuarioModel;

    public MedicoModel() {
    }

    public MedicoModel(long id, String nome, String cpf, String especialidade, List<ConsultaModel> consultaModels) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.especialidade = especialidade;
        this.consultaModels = consultaModels;
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

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<ConsultaModel> getConsultaModels() {
        return consultaModels;
    }

    public void setConsultaModels(List<ConsultaModel> consultaModels) {
        this.consultaModels = consultaModels;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long id;
        private String nome;
        private String cpf;
        private String especialidade;
        private List<ConsultaModel> consultaModels;

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

        public Builder especialidade(String especialidade) {
            this.especialidade = especialidade;
            return this;
        }

        public Builder consultaModels(List<ConsultaModel> consultaModels) {
            this.consultaModels = consultaModels;
            return this;
        }

        public MedicoModel build() {
            return new MedicoModel(id, nome, cpf, especialidade, consultaModels);
        }
    }
}
