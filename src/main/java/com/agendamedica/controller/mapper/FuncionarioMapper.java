package com.agendamedica.controller.mapper;

import com.agendamedica.controller.request.FuncionarioRequest;
import com.agendamedica.controller.response.FuncionarioResponse;
import com.agendamedica.entity.FuncionarioModel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class FuncionarioMapper {
    public static FuncionarioModel toFuncionario(FuncionarioRequest funcionarioRequest) {
        return FuncionarioModel.builder()
                .nome(funcionarioRequest.nome())
                .cpf(funcionarioRequest.cpf())
                .funcao(funcionarioRequest.funcao())
                .build();
    }

    public static FuncionarioResponse toFuncionarioResponse(FuncionarioModel funcionarioModel) {
        return FuncionarioResponse
                .builder()
                .id(funcionarioModel.getId())
                .nome(funcionarioModel.getNome())
                .funcao(funcionarioModel.getFuncao())
                .build();
    }
}
