package com.agendamedica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "data", nullable = false)
    private LocalDateTime dataConsulta;

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
}
