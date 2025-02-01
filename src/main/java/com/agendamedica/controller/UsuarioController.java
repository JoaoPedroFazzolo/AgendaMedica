package com.agendamedica.controller;

import com.agendamedica.controller.mapper.UsuarioMapper;
import com.agendamedica.controller.request.UsuarioRequest;
import com.agendamedica.controller.response.UsuarioResponse;
import com.agendamedica.entity.UsuarioModel;
import com.agendamedica.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/criar")
    public ResponseEntity<UsuarioResponse> criarUsuario(@RequestBody UsuarioRequest request) {
        UsuarioModel usuarioModel = UsuarioMapper.toUsuario(request);
        UsuarioModel usuarioSalvo = service.criarUsuario(usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toUsuarioResponse(usuarioSalvo));
    }
}
