package com.agendamedica.service;

import com.agendamedica.entity.FuncionarioModel;
import com.agendamedica.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public List<FuncionarioModel> listar() {
        return funcionarioRepository.findAll();
    }
}
