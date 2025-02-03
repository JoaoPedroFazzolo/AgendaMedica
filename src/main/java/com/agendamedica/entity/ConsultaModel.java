package com.agendamedica.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @Column(name = "criado_em", nullable = false)
    @CreationTimestamp
    private LocalDateTime criadoEm;

}
