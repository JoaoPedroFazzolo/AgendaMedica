package com.agendamedica.controller;

import com.agendamedica.controller.mapper.MedicoMapper;
import com.agendamedica.controller.request.MedicoRequest;
import com.agendamedica.controller.response.MedicoResponse;
import com.agendamedica.entity.MedicoModel;
import com.agendamedica.service.MedicoService;
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
    public List<MedicoResponse> listar() {
        List<MedicoModel> medicos = medicoService.listar();
        return medicos.stream()
                .map(MedicoMapper::toMedicoResponse)
                .toList();
    }

    @PostMapping("/salvar")
    public MedicoResponse salvar(@RequestBody MedicoRequest request) {
        MedicoModel novoMedico = MedicoMapper.toMedico(request);
        MedicoModel medicoSalvo = medicoService.salvar(novoMedico);
        return MedicoMapper.toMedicoResponse(medicoSalvo);
    }

    @GetMapping("/{id}")
    public MedicoResponse buscarPorId(@PathVariable Long id) {
        Optional<MedicoModel> medico = medicoService.buscarPorId(id);
        if (medico.isPresent()) {
            return MedicoMapper.toMedicoResponse(medico.get());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        medicoService.excluir(id);
    }

}
