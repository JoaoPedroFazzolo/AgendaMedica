package com.agendamedica.controller;

import com.agendamedica.controller.mapper.FuncionarioMapper;
import com.agendamedica.controller.request.FuncionarioRequest;
import com.agendamedica.controller.response.FuncionarioResponse;
import com.agendamedica.entity.FuncionarioModel;
import com.agendamedica.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<FuncionarioResponse>> listar() {
        return ResponseEntity.ok(funcionarioService.listar()
                .stream()
                .map(FuncionarioMapper::toFuncionarioResponse)
                .toList());
    }

    @PostMapping("/salvar")
    public ResponseEntity<FuncionarioResponse> salvar(@RequestBody FuncionarioRequest request) {
        FuncionarioModel novoFuncionario = FuncionarioMapper.toFuncionario(request);
        FuncionarioModel funcionarioSalvo = funcionarioService.salvar(novoFuncionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(FuncionarioMapper.toFuncionarioResponse(funcionarioSalvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponse> buscarPorId(@PathVariable Long id) {
        return funcionarioService.buscarPorId(id).map(funcionario -> ResponseEntity.ok(FuncionarioMapper.toFuncionarioResponse(funcionario)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<FuncionarioResponse> alterar(@RequestBody FuncionarioRequest request, @PathVariable Long id) {
        return funcionarioService.atualizar(id, FuncionarioMapper.toFuncionario(request))
                .map(funcionario -> ResponseEntity.ok(FuncionarioMapper.toFuncionarioResponse(funcionario)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Optional<FuncionarioModel> optionalFuncionarioModel = funcionarioService.buscarPorId(id);
        if (optionalFuncionarioModel.isPresent()) {
            funcionarioService.excluir(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();

    }
}
