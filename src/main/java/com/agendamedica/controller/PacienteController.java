package com.agendamedica.controller;


import com.agendamedica.entity.PacienteModel;
import com.agendamedica.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamedica/paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<PacienteModel> listar() {
        return pacienteService.listar();
    }

    @PostMapping("/salvar")
    public PacienteModel salvar(@RequestBody PacienteModel paciente) {
        return pacienteService.salvar(paciente);
    }

}
