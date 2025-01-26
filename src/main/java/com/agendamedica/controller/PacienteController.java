package com.agendamedica.controller;

import com.agendamedica.controller.mapper.PacienteMapper;
import com.agendamedica.controller.request.PacienteRequest;
import com.agendamedica.controller.response.PacienteResponse;
import com.agendamedica.entity.PacienteModel;
import com.agendamedica.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/agendamedica/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponse>> listar() {
        return ResponseEntity.ok(pacienteService.listar()
                .stream()
                .map(PacienteMapper::toPacienteResponse)
                .toList());
    }

    @PostMapping("/salvar")
    public ResponseEntity<PacienteResponse> salvar(@RequestBody PacienteRequest request) {
        PacienteModel pacienteModel = PacienteMapper.toPaciente(request);
        PacienteModel pacienteSalvo = pacienteService.salvar(pacienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(PacienteMapper.toPacienteResponse(pacienteSalvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> buscarPorId(@PathVariable Long id) {
        return pacienteService.buscarPorId(id).map(paciente -> ResponseEntity.ok(PacienteMapper.toPacienteResponse(paciente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<PacienteResponse> alterar(@RequestBody PacienteRequest request, @PathVariable Long id) {
        return pacienteService.atualizar(id, PacienteMapper.toPaciente(request))
                .map(paciente -> ResponseEntity.ok(PacienteMapper.toPacienteResponse(paciente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Optional<PacienteModel> optionalPacienteModel = pacienteService.buscarPorId(id);
        if (optionalPacienteModel.isPresent()) {
            pacienteService.excluir(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
