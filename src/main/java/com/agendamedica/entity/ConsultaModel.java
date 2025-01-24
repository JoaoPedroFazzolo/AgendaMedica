package com.agendamedica.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

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

    public ConsultaModel() {
    }

    public ConsultaModel(long id, MedicoModel medicoModel, PacienteModel pacienteModel, LocalDateTime dataConsulta) {
        this.id = id;
        this.medicoModel = medicoModel;
        this.pacienteModel = pacienteModel;
        this.dataConsulta = dataConsulta;
    }

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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private long id;
        private MedicoModel medicoModel;
        private PacienteModel pacienteModel;
        private LocalDateTime dataConsulta;

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

        public ConsultaModel build() {
            return new ConsultaModel(id, medicoModel, pacienteModel, dataConsulta);
        }
    }
}
