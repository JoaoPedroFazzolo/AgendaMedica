package com.agendamedica.controller.interfaces;

import com.agendamedica.controller.request.PacienteRequest;
import com.agendamedica.controller.response.PacienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Paciente", description = "Recurso responsavel pelo gerenciamento de pacientes")
public interface PacienteInterface {

    @Operation(summary = "Listar Pacientes", description = "Metodo responsavel por listar todos os pacientes",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Pacientes retornados com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = PacienteResponse.class))))
    ResponseEntity<List<PacienteResponse>> listar();

    @Operation(summary = "Criar Pacientes", description = "Metodo responsavel por criar todos os pacientes",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Paciente criado com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = PacienteResponse.class))))
    ResponseEntity<PacienteResponse> salvar(@Valid @RequestBody PacienteRequest request);

    @Operation(summary = "Buscar Paciente por id", description = "Metodo responsavel por buscar paciente por id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Paciente encontrado com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = PacienteResponse.class))))
    @ApiResponse(responseCode = "404", description = "Paciente não encontrado", content = @Content())
    ResponseEntity<PacienteResponse> buscarPorId(@PathVariable Long id);

    @Operation(summary = "Alterar um paciente por id", description = "Metodo responsavel por alterar paciente atraves do id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Paciente encontrado com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = PacienteResponse.class))))
    @ApiResponse(responseCode = "404", description = "Paciente não encontrado", content = @Content())
    ResponseEntity<PacienteResponse> alterar(@Valid @RequestBody PacienteRequest request, @PathVariable Long id) ;

    @Operation(summary = "Excluir um paciente por id", description = "Metodo responsavel por excluir paciente atraves do id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Paciente excluido com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = PacienteResponse.class))))
    @ApiResponse(responseCode = "404", description = "Paciente não encontrado", content = @Content())
    ResponseEntity<Void> remover(@PathVariable Long id);
}
