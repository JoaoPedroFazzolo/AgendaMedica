package com.agendamedica.controller.interfaces;


import com.agendamedica.controller.request.FuncionarioRequest;
import com.agendamedica.controller.response.FuncionarioResponse;
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

@Tag(name = "Funcionario", description = "Recurso responsavel pelo gerenciamento de funcionarios")
public interface FuncionarioInterface {

    @Operation(summary = "Listar Funcionarios", description = "Metodo responsavel por listar todos os funcionarios",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Funcionarios retornados com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = FuncionarioResponse.class))))
    ResponseEntity<List<FuncionarioResponse>> listar();

    @Operation(summary = "Criar Funcionarios", description = "Metodo responsavel por criar todos os funcionarios",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "201", description = "Funcionarios criado com sucesso",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = FuncionarioResponse.class))))
    ResponseEntity<FuncionarioResponse> salvar(@Valid @RequestBody FuncionarioRequest request);

    @Operation(summary = "Buscar Funcionario por id", description = "Metodo responsavel por buscar funcionario por id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Funcionario encontrado com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = FuncionarioResponse.class))))
    @ApiResponse(responseCode = "404", description = "Funcionario não encontrado", content = @Content())
    ResponseEntity<FuncionarioResponse> buscarPorId(@PathVariable Long id);

    @Operation(summary = "Alterar um Funcionario por id", description = "Metodo responsavel por alterar funcionario atraves do id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "200", description = "Funcionario encontrado com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = FuncionarioResponse.class))))
    @ApiResponse(responseCode = "404", description = "Funcionario não encontrado", content = @Content())
    ResponseEntity<FuncionarioResponse> alterar(@Valid @RequestBody FuncionarioRequest request, @PathVariable Long id);

    @Operation(summary = "Excluir um Funcionario por id", description = "Metodo responsavel por excluir funcionario atraves do id",
            security = @SecurityRequirement(name = "bearerAuth"))
    @ApiResponse(responseCode = "204", description = "Funcionario excluido com sucesso ",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = FuncionarioResponse.class))))
    @ApiResponse(responseCode = "404", description = "Funcionario não encontrado", content = @Content())
    ResponseEntity<Void> remover(@PathVariable Long id);
}
