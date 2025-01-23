package com.agendamedica.controller;

import com.agendamedica.entity.FuncionarioModel;
import com.agendamedica.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamedica/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<FuncionarioModel> listar() {
        return funcionarioService.listar();
    }

    @PostMapping("/salvar")
    public FuncionarioModel salvar(@RequestBody FuncionarioModel funcionario) {
        return funcionarioService.salvar(funcionario);
    }
}
