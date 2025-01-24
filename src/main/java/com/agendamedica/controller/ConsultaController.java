package com.agendamedica.controller;

import com.agendamedica.controller.mapper.ConsultaMapper;
import com.agendamedica.controller.request.ConsultaRequest;
import com.agendamedica.controller.response.ConsultaResponse;
import com.agendamedica.entity.ConsultaModel;
import com.agendamedica.service.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendamedica/consulta")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> listar() {
        return ResponseEntity.ok(consultaService.listar()
                .stream()
                .map(ConsultaMapper::toConsultaResponse)
                .toList());
    }

    @PostMapping("/salvar")
    public ResponseEntity<ConsultaResponse> salvar(@RequestBody ConsultaRequest request) {
        ConsultaModel novaConsulta = ConsultaMapper.toConsulta(request);
        ConsultaModel consultaSalva = consultaService.salvar(novaConsulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(ConsultaMapper.toConsultaResponse(consultaSalva));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> buscarPorId(@PathVariable Long id) {
        return consultaService.buscarPorId(id).map(consulta -> ResponseEntity.ok(ConsultaMapper.toConsultaResponse(consulta)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        consultaService.excluir(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
