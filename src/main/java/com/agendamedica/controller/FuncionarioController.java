package com.agendamedica.controller;

import com.agendamedica.controller.mapper.FuncionarioMapper;
import com.agendamedica.controller.request.FuncionarioRequest;
import com.agendamedica.controller.response.FuncionarioResponse;
import com.agendamedica.entity.FuncionarioModel;
import com.agendamedica.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendamedica/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public List<FuncionarioResponse> listar() {
        List<FuncionarioModel> funcionarios = funcionarioService.listar();
        return funcionarios.stream()
                .map(FuncionarioMapper::toFuncionarioResponse)
                .toList();
    }

    @PostMapping("/salvar")
    public FuncionarioResponse salvar(@RequestBody FuncionarioRequest request) {
        FuncionarioModel novoFuncionario = FuncionarioMapper.toFuncionario(request);
        FuncionarioModel funcionarioSalvo = funcionarioService.salvar(novoFuncionario);
        return FuncionarioMapper.toFuncionarioResponse(funcionarioSalvo);
    }

    @GetMapping("/{id}")
    public FuncionarioResponse buscarPorId(@PathVariable Long id) {
        Optional<FuncionarioModel> funcionario = funcionarioService.buscarPorId(id);
        if (funcionario.isPresent()) {
            return FuncionarioMapper.toFuncionarioResponse(funcionario.get());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        funcionarioService.excluir(id);
    }
}
