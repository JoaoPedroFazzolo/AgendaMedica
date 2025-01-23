package com.agendamedica.controller;

import com.agendamedica.controller.mapper.PacienteMapper;
import com.agendamedica.controller.request.PacienteRequest;
import com.agendamedica.controller.response.PacienteResponse;
import com.agendamedica.entity.PacienteModel;
import com.agendamedica.service.PacienteService;
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
    public List<PacienteResponse> listar() {
        List<PacienteModel> pacientes = pacienteService.listar();
        return pacientes.stream()
                .map(PacienteMapper::toPacienteResponse)
                .toList();
    }

    @PostMapping("/salvar")
    public PacienteResponse salvar(@RequestBody PacienteRequest request) {
        PacienteModel pacienteModel = PacienteMapper.toPaciente(request);
        PacienteModel pacienteSalvo = pacienteService.salvar(pacienteModel);
        return PacienteMapper.toPacienteResponse(pacienteSalvo);
    }

    @GetMapping("/{id}")
    public PacienteResponse buscarPorId(@PathVariable Long id) {
        Optional<PacienteModel> paciente = pacienteService.buscarPorId(id);
        if (paciente.isPresent()) {
            return PacienteMapper.toPacienteResponse(paciente.get());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        pacienteService.excluir(id);
    }
}
