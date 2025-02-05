package com.agendamedica.controller;

import com.agendamedica.controller.interfaces.ConsultaInterface;
import com.agendamedica.controller.mapper.ConsultaMapper;
import com.agendamedica.controller.request.ConsultaRequest;
import com.agendamedica.controller.response.ConsultaResponse;
import com.agendamedica.entity.ConsultaModel;
import com.agendamedica.service.ConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamedica/consulta")
public class ConsultaController implements ConsultaInterface {

    private final ConsultaService consultaService;

    @GetMapping
    public ResponseEntity<List<ConsultaResponse>> listar() {
        return ResponseEntity.ok(consultaService.listar()
                .stream()
                .map(ConsultaMapper::toConsultaResponse)
                .toList());
    }

    @PostMapping("/salvar")
    public ResponseEntity<ConsultaResponse> salvar(@Valid @RequestBody ConsultaRequest request) {
        ConsultaModel novaConsulta = ConsultaMapper.toConsulta(request);
        ConsultaModel consultaSalva = consultaService.salvar(novaConsulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(ConsultaMapper.toConsultaResponse(consultaSalva));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponse> buscarPorId(@PathVariable Long id) {
        return consultaService.buscarPorId(id).map(consulta -> ResponseEntity.ok(ConsultaMapper.toConsultaResponse(consulta)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<ConsultaResponse> alterar(@Valid @RequestBody ConsultaRequest request, @PathVariable Long id) {
        return consultaService.atualizar(id, ConsultaMapper.toConsulta(request))
                .map(consulta -> ResponseEntity.ok(ConsultaMapper.toConsultaResponse(consulta)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        Optional<ConsultaModel> optionalConsulta = consultaService.buscarPorId(id);
        if (optionalConsulta.isPresent()) {
            consultaService.excluir(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/busca/medico")
    public ResponseEntity<List<ConsultaResponse>> listarPorMedico(@RequestParam Long medico) {
        return ResponseEntity.ok(consultaService.buscaPorMedico(medico).stream().map(ConsultaMapper::toConsultaResponse).toList());
    }

    @GetMapping("/busca/paciente")
    public ResponseEntity<List<ConsultaResponse>> listarPorPaciente(@RequestParam Long paciente) {
        return ResponseEntity.ok(consultaService.buscaPorPaciente(paciente).stream().map(ConsultaMapper::toConsultaResponse).toList());
    }

    @GetMapping("/busca/dataconsulta")
    public ResponseEntity<List<ConsultaResponse>> listarPorDataConsulta(@RequestParam LocalDate dataConsulta) {
        return ResponseEntity.ok(consultaService.buscaPorDataDaConsulta(dataConsulta).stream().map(ConsultaMapper::toConsultaResponse).toList());
    }

    @GetMapping("/busca/criacaoconsulta")
    public ResponseEntity<List<ConsultaResponse>> listarPorDataCriacaoConsulta(@RequestParam LocalDate criacaoConsulta) {
        return ResponseEntity.ok(consultaService.buscaPorDataDaCriacaoConsulta(criacaoConsulta).stream().map(ConsultaMapper::toConsultaResponse).toList());
    }
}
