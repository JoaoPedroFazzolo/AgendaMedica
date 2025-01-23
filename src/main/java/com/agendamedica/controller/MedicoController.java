package com.agendamedica.controller;

import com.agendamedica.entity.MedicoModel;
import com.agendamedica.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamedica/medico")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public List<MedicoModel> listar() {
        return medicoService.listar();
    }

    @PostMapping("/salvar")
    public MedicoModel salvar(@RequestBody MedicoModel medico) {
        return medicoService.salvar(medico);
    }

}
