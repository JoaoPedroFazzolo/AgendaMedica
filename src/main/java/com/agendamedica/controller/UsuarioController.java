package com.agendamedica.controller;

import com.agendamedica.config.TokenService;
import com.agendamedica.controller.mapper.UsuarioMapper;
import com.agendamedica.controller.request.LoginRequest;
import com.agendamedica.controller.request.UsuarioRequest;
import com.agendamedica.controller.response.LoginResponse;
import com.agendamedica.controller.response.UsuarioResponse;
import com.agendamedica.entity.UsuarioModel;
import com.agendamedica.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agendamedica/auth")
public class UsuarioController {

    private final UsuarioService service;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    public UsuarioController(UsuarioService service, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.service = service;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/criar")
    public ResponseEntity<UsuarioResponse> criarUsuario(@RequestBody UsuarioRequest request) {
        UsuarioModel usuarioModel = UsuarioMapper.toUsuario(request);
        UsuarioModel usuarioSalvo = service.criarUsuario(usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toUsuarioResponse(usuarioSalvo));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.senha());
        Authentication authenticate = authenticationManager.authenticate(userAndPass);
        UsuarioModel usuarioModel = (UsuarioModel) authenticate.getPrincipal();
        String token = tokenService.generateToken(usuarioModel);
        return ResponseEntity.ok(new LoginResponse(token));
    }
}
