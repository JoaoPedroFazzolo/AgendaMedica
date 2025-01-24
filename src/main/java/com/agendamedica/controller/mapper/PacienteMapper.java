package com.agendamedica.controller.mapper;

import com.agendamedica.controller.request.PacienteRequest;
import com.agendamedica.controller.response.PacienteResponse;
import com.agendamedica.entity.ConsultaModel;
import com.agendamedica.entity.PacienteModel;
import lombok.experimental.UtilityClass;

import java.util.List;


@UtilityClass
public class PacienteMapper {

    public static PacienteModel toPaciente(PacienteRequest pacienteRequest) {
        return PacienteModel
                .builder()
                .nome(pacienteRequest.nome())
                .cpf(pacienteRequest.cpf())
                .telefone(pacienteRequest.telefone())
                .consultaModels((List<ConsultaModel>) pacienteRequest.consultaModel())
                .build();
    }

    public static PacienteResponse toPacienteResponse(PacienteModel pacienteModel) {
        return PacienteResponse
                .builder()
                .id(pacienteModel.getId())
                .nome(pacienteModel.getNome())
                .cpf(pacienteModel.getCpf())
                .telefone(pacienteModel.getTelefone())
                .consultaModel(pacienteModel.getConsultaModels())
                .build();
    }
}
