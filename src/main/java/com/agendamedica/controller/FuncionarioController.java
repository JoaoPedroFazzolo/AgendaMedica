package com.agendamedica.controller;

import com.agendamedica.entity.FuncionarioModel;
import com.agendamedica.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamedica/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @GetMapping("/listar")
    public List<FuncionarioModel> listar() {
        return funcionarioService.listar();
    }
}
