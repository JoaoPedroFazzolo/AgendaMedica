package com.agendamedica.controller.interfaces;

import com.agendamedica.controller.request.MedicoRequest;
import com.agendamedica.controller.response.MedicoResponse;
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

@Tag(name = "Medico", description = "Recurso responsavel pelo gerenciamento de medicos")
public interface MedicoInterface {

    @Operation(summary = "Listar Medicos", description = "Metodo responsavel por listar todos os medicos",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Medicos retornados com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MedicoResponse.class))))
    ResponseEntity<List<MedicoResponse>> listar();

    @Operation(summary = "Criar Medicos", description = "Metodo responsavel por criar todos os medicos",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Medico criado com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MedicoResponse.class))))
    ResponseEntity<MedicoResponse> salvar(@Valid @RequestBody MedicoRequest request);

    @Operation(summary = "Buscar Medico por id", description = "Metodo responsavel por buscar medico por id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Medico encontrado com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MedicoResponse.class))))
    @ApiResponse(responseCode = "404", description = "Medico não encontrado", content = @Content())
    ResponseEntity<MedicoResponse> buscarPorId(@PathVariable Long id);

    @Operation(summary = "Alterar um medico por id", description = "Metodo responsavel por alterar medico atraves do id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Medico encontrado com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MedicoResponse.class))))
    @ApiResponse(responseCode = "404", description = "Medico não encontrado", content = @Content())
    ResponseEntity<MedicoResponse> alterar(@Valid @RequestBody MedicoRequest request, @PathVariable Long id);

    @Operation(summary = "Excluir um medico por id", description = "Metodo responsavel por excluir medicos atraves do id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Medico excluido com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MedicoResponse.class))))
    @ApiResponse(responseCode = "404", description = "Medico não encontrado", content = @Content())
    ResponseEntity<Void> remover(@PathVariable Long id);
}
