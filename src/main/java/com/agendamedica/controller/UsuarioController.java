package com.agendamedica.controller;

import com.agendamedica.config.TokenService;
import com.agendamedica.controller.interfaces.UsuarioInterface;
import com.agendamedica.controller.mapper.UsuarioMapper;
import com.agendamedica.controller.request.LoginRequest;
import com.agendamedica.controller.request.UsuarioRequest;
import com.agendamedica.controller.response.LoginResponse;
import com.agendamedica.controller.response.UsuarioResponse;
import com.agendamedica.entity.UsuarioModel;
import com.agendamedica.exception.UsernameOrPasswordInvalidException;
import com.agendamedica.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendamedica/auth")
@RequiredArgsConstructor
public class UsuarioController implements UsuarioInterface {

    private final UsuarioService service;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/criar")
    public ResponseEntity<UsuarioResponse> criarUsuario(@Valid @RequestBody UsuarioRequest request) {
        UsuarioModel usuarioModel = UsuarioMapper.toUsuario(request);
        UsuarioModel usuarioSalvo = service.criarUsuario(usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toUsuarioResponse(usuarioSalvo));
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        try {
            UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
            Authentication authenticate = authenticationManager.authenticate(userAndPass);
            UsuarioModel usuarioModel = (UsuarioModel) authenticate.getPrincipal();
            String token = tokenService.generateToken(usuarioModel);
            return ResponseEntity.ok(new LoginResponse(token));
        } catch (BadCredentialsException e) {
            throw new UsernameOrPasswordInvalidException("Usuario ou senha inválida");
        }
    }
}
