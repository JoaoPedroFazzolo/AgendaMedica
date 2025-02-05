package com.agendamedica.controller.interfaces;

import com.agendamedica.controller.mapper.ConsultaMapper;
import com.agendamedica.controller.request.ConsultaRequest;
import com.agendamedica.controller.response.ConsultaResponse;
import com.agendamedica.controller.response.FuncionarioResponse;
import com.agendamedica.entity.ConsultaModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Tag(name = "Consulta", description = "Recurso responsavel pelo gerenciamento de funcionarios")
public interface ConsultaInterface {

    @Operation(summary = "Listar Consultas", description = "Metodo responsavel por listar todos as consultas",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Consultas retornadas com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ConsultaResponse.class))))
    ResponseEntity<List<ConsultaResponse>> listar();

    @Operation(summary = "Criar Consultas", description = "Metodo responsavel por criar todas as consultas",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Consultas criadas com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ConsultaResponse.class))))
    ResponseEntity<ConsultaResponse> salvar(@Valid @RequestBody ConsultaRequest request);

    @Operation(summary = "Buscar Consulta por id", description = "Metodo responsavel por buscar consultas por id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Consulta encontrada com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ConsultaResponse.class))))
    @ApiResponse(responseCode = "404", description = "Consulta não encontrada", content = @Content())
    ResponseEntity<ConsultaResponse> buscarPorId(@PathVariable Long id);

    @Operation(summary = "Alterar uma Consulta por id", description = "Metodo responsavel por alterar consultas atraves do id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Consulta encontrado com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ConsultaResponse.class))))
    @ApiResponse(responseCode = "404", description = "Consulta não encontrada", content = @Content())
    ResponseEntity<ConsultaResponse> alterar(@Valid @RequestBody ConsultaRequest request, @PathVariable Long id);

    @Operation(summary = "Excluir uma Consulta por id", description = "Metodo responsavel por excluir consulta atraves do id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Consulta excluida com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ConsultaResponse.class))))
    @ApiResponse(responseCode = "404", description = "Consulta não encontrada", content = @Content())
    ResponseEntity<Void> remover(@PathVariable Long id);

    @Operation(summary = "Buscar Consulta por medico", description = "Metodo responsavel por buscar consultas atraves do id do medico",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Consulta encontrada com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ConsultaResponse.class))))
    @ApiResponse(responseCode = "404", description = "Consulta não encontrada", content = @Content())
    ResponseEntity<List<ConsultaResponse>> listarPorMedico(@RequestParam Long medico);

    @Operation(summary = "Buscar Consulta por paciente", description = "Metodo responsavel por buscar consultas atraves do id do paciente",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Consulta encontrada com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ConsultaResponse.class))))
    @ApiResponse(responseCode = "404", description = "Consulta não encontrada", content = @Content())
    ResponseEntity<List<ConsultaResponse>> listarPorPaciente(@RequestParam Long paciente);

    @Operation(summary = "Buscar Consulta atraves de sua data", description = "Metodo responsavel por buscar consultas atraves da data de agendamento",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Consulta encontrada com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ConsultaResponse.class))))
    @ApiResponse(responseCode = "404", description = "Consulta não encontrada", content = @Content())
    ResponseEntity<List<ConsultaResponse>> listarPorDataConsulta(@RequestParam LocalDate dataConsulta);

    @Operation(summary = "Buscar Consulta da data de criacao", description = "Metodo responsavel por buscar consultas atraves da data de criacao da caonsulta",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Consulta encontrada com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = ConsultaResponse.class))))
    @ApiResponse(responseCode = "404", description = "Consulta não encontrada", content = @Content())
    ResponseEntity<List<ConsultaResponse>> listarPorDataCriacaoConsulta(@RequestParam LocalDate criacaoConsulta);
}
