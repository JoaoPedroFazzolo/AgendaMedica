package com.agendamedica.controller;

import com.agendamedica.entity.ConsultaModel;
import com.agendamedica.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamedica/consulta")
public class ConsultaController {

    public final ConsultaService consultaService;

    @GetMapping("/listar")
    public List<ConsultaModel> listar() {
        return consultaService.listar();
    }
}
