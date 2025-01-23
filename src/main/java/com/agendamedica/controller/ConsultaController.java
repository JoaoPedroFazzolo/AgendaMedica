package com.agendamedica.controller;

import com.agendamedica.controller.mapper.ConsultaMapper;
import com.agendamedica.controller.request.ConsultaRequest;
import com.agendamedica.controller.response.ConsultaResponse;
import com.agendamedica.entity.ConsultaModel;
import com.agendamedica.service.ConsultaService;
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
    public List<ConsultaResponse> listar() {
        List<ConsultaModel> consultas = consultaService.listar();
        return consultas.stream()
                .map(ConsultaMapper::toConsultaResponse)
                .toList();
    }

    @PostMapping("/salvar")
    public ConsultaResponse salvar(@RequestBody ConsultaRequest request) {
        ConsultaModel novaConsulta = ConsultaMapper.toConsulta(request);
        ConsultaModel consultaSalva = consultaService.salvar(novaConsulta);
        return ConsultaMapper.toConsultaResponse(consultaSalva);
    }

    @GetMapping("/{id}")
    public ConsultaResponse buscarPorId(@PathVariable Long id) {
        Optional<ConsultaModel> consulta = consultaService.buscarPorId(id);
        if (consulta.isPresent()) {
            return ConsultaMapper.toConsultaResponse(consulta.get());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        consultaService.excluir(id);
    }
}
