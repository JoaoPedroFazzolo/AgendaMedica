package com.agendamedica.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "consulta")
public class ConsultaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "medico_id", referencedColumnName = "id", nullable = false)
    private MedicoModel medicoModel;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "id", nullable = false)
    private PacienteModel pacienteModel;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "data", nullable = false)
    private LocalDateTime dataConsulta;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "criado_em", nullable = false)
    @CreationTimestamp
    private LocalDateTime criadoEm;

    // Construtor padrão
    public ConsultaModel() {}

    // Construtor privado para Builder
    private ConsultaModel(Builder builder) {
        this.id = builder.id;
        this.medicoModel = builder.medicoModel;
        this.pacienteModel = builder.pacienteModel;
        this.dataConsulta = builder.dataConsulta;
        this.criadoEm = builder.criadoEm;
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MedicoModel getMedicoModel() {
        return medicoModel;
    }

    public void setMedicoModel(MedicoModel medicoModel) {
        this.medicoModel = medicoModel;
    }

    public PacienteModel getPacienteModel() {
        return pacienteModel;
    }

    public void setPacienteModel(PacienteModel pacienteModel) {
        this.pacienteModel = pacienteModel;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public static ConsultaModel.Builder builder() {
        return new ConsultaModel.Builder();
    }

    public static class Builder {
        private long id;
        private MedicoModel medicoModel;
        private PacienteModel pacienteModel;
        private LocalDateTime dataConsulta;
        private LocalDateTime criadoEm;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder medicoModel(MedicoModel medicoModel) {
            this.medicoModel = medicoModel;
            return this;
        }

        public Builder pacienteModel(PacienteModel pacienteModel) {
            this.pacienteModel = pacienteModel;
            return this;
        }

        public Builder dataConsulta(LocalDateTime dataConsulta) {
            this.dataConsulta = dataConsulta;
            return this;
        }

        public Builder criadoEm(LocalDateTime criadoEm) {
            this.criadoEm = criadoEm;
            return this;
        }

        public ConsultaModel build() {
            return new ConsultaModel(this);
        }
    }
}
