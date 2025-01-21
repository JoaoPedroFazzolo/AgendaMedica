package com.agendamedica.controller;

import com.agendamedica.entity.MedicoModel;
import com.agendamedica.service.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamedica/medico")
public class MedicoController {

    public final MedicoService medicoService;

    @GetMapping("/listar")
    public List<MedicoModel> listar() {
        return medicoService.listar();
    }


}
