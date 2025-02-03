package com.agendamedica.controller;

import com.agendamedica.controller.mapper.MedicoMapper;
import com.agendamedica.controller.request.MedicoRequest;
import com.agendamedica.controller.response.MedicoResponse;
import com.agendamedica.entity.MedicoModel;
import com.agendamedica.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendamedica/medico")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<List<MedicoResponse>> listar() {;
        return ResponseEntity.ok(medicoService.listar()
                .stream()
                .map(MedicoMapper::toMedicoResponse)
                .toList());
    }

    @PostMapping("/salvar")
    public ResponseEntity<MedicoResponse> salvar(@Valid @RequestBody MedicoRequest request) {
        MedicoModel novoMedico = MedicoMapper.toMedico(request);
        MedicoModel medicoSalvo = medicoService.salvar(novoMedico);
        return ResponseEntity.status(HttpStatus.CREATED).body(MedicoMapper.toMedicoResponse(medicoSalvo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoResponse> buscarPorId(@PathVariable Long id) {
        return medicoService.buscarPorId(id).map(medico -> ResponseEntity.ok(MedicoMapper.toMedicoResponse(medico)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<MedicoResponse> alterar(@Valid @RequestBody MedicoRequest request, @PathVariable Long id) {
        return medicoService.atualizar(id, MedicoMapper.toMedico(request))
                .map(medico -> ResponseEntity.ok(MedicoMapper.toMedicoResponse(medico)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Optional<MedicoModel> optionalMedicoModel = medicoService.buscarPorId(id);
        if (optionalMedicoModel.isPresent()) {
            medicoService.excluir(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }

}
