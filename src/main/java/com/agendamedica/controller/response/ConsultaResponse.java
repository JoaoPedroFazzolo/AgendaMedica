package com.agendamedica.controller.response;

import com.agendamedica.entity.MedicoModel;
import com.agendamedica.entity.PacienteModel;

import java.time.LocalDateTime;

public record ConsultaResponse(Long id, MedicoModel medicoModel, PacienteModel pacienteModel, LocalDateTime dataConsulta, LocalDateTime criadoEm) {

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private MedicoModel medicoModel;
        private PacienteModel pacienteModel;
        private LocalDateTime dataConsulta;
        private LocalDateTime criadoEm;

        public Builder id(Long id) {
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

        public ConsultaResponse build() {
            return new ConsultaResponse(id, medicoModel, pacienteModel, dataConsulta, LocalDateTime.now());
        }
    }
}
