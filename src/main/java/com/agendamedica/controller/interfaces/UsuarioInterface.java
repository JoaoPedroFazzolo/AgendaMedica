package com.agendamedica.controller.interfaces;

import com.agendamedica.controller.request.LoginRequest;
import com.agendamedica.controller.request.UsuarioRequest;
import com.agendamedica.controller.response.LoginResponse;
import com.agendamedica.controller.response.UsuarioResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Usuario", description = "Recurso responsavel pelo gerenciamento de usuarios")
public interface UsuarioInterface {

    @Operation(summary = "Criar usuario", description = "Metodo responsavel por criar um usuario")
    @ApiResponse(responseCode = "201", description = "Usuario criado com sucesso",
            content = @Content(schema = @Schema(implementation = UsuarioResponse.class)))
    ResponseEntity<UsuarioResponse> criarUsuario(@Valid @RequestBody UsuarioRequest request);

    @Operation(summary = "Login de usuario", description = "Metodo responsavel por logar um usuario")
    @ApiResponse(responseCode = "200", description = "Usuario logado com sucesso",
            content = @Content(schema = @Schema(implementation = LoginResponse.class)))
    ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request);
}
