package com.agendamedica.controller;


import com.agendamedica.entity.PacienteModel;
import com.agendamedica.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamedica/paciente")
public class PacienteController {

    public final PacienteService pacienteService;


    @GetMapping("/listar")
    public List<PacienteModel> listar() {
        return pacienteService.listar();
    }
}
