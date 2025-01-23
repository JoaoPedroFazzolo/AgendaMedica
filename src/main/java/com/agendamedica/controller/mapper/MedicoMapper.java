package com.agendamedica.controller.mapper;

import com.agendamedica.controller.request.MedicoRequest;
import com.agendamedica.controller.response.MedicoResponse;
import com.agendamedica.entity.ConsultaModel;
import com.agendamedica.entity.MedicoModel;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MedicoMapper {
    public static MedicoModel toMedico(MedicoRequest medicoRequest) {
        return MedicoModel
                .builder()
                .nome(medicoRequest.nome())
                .cpf(medicoRequest.cpf())
                .especialidade(medicoRequest.especialidade())
                .consultaModels((List<ConsultaModel>) medicoRequest.consultaModel())
                .build();
    }

    public static MedicoResponse toMedicoResponse(MedicoModel medicoModel) {
        return MedicoResponse
                .builder()
                .id(medicoModel.getId())
                .nome(medicoModel.getNome())
                .cpf(medicoModel.getCpf())
                .especialidade(medicoModel.getEspecialidade())
                .consultaModel((ConsultaModel) medicoModel.getConsultaModels())
                .build();
    }
}
