package com.agendamedica.service;

import com.agendamedica.entity.FuncionarioModel;
import com.agendamedica.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<FuncionarioModel> listar() {
        return funcionarioRepository.findAll();
    }

    public FuncionarioModel salvar(FuncionarioModel funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Optional<FuncionarioModel> buscarPorId(Long id) {
        return funcionarioRepository.findById(id);
    }

    public void excluir(Long id) {
        funcionarioRepository.deleteById(id);
    }
}
