package com.agendamedica.controller.mapper;

import com.agendamedica.controller.request.ConsultaRequest;
import com.agendamedica.controller.response.ConsultaResponse;
import com.agendamedica.entity.ConsultaModel;
import lombok.experimental.*;

@UtilityClass
public class ConsultaMapper {
    public static ConsultaModel toConsulta(ConsultaRequest consultaRequest) {
        return ConsultaModel
                .builder()
                .medicoModel(consultaRequest.medicoModel())
                .pacienteModel(consultaRequest.pacienteModel())
                .build();
    }

    public static ConsultaResponse toConsultaResponse(ConsultaModel consultaModel) {
        return ConsultaResponse
                .builder()
                .id(consultaModel.getId())
                .medicoModel(consultaModel.getMedicoModel())
                .pacienteModel(consultaModel.getPacienteModel())
                .build();
    }
}
