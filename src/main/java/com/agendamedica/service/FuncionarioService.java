package com.agendamedica.service;

import com.agendamedica.entity.FuncionarioModel;
import com.agendamedica.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<FuncionarioModel> listar() {
        return repository.findAll();
    }

    public FuncionarioModel salvar(FuncionarioModel funcionario) {
        return repository.save(funcionario);
    }

    public Optional<FuncionarioModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<FuncionarioModel> atualizar(Long id, FuncionarioModel updateFuncionairo) {
        Optional<FuncionarioModel> optionalFuncionario = repository.findById(id);
        if (optionalFuncionario.isPresent()) {
            FuncionarioModel funciionario = optionalFuncionario.get();
            funciionario.setNome(updateFuncionairo.getNome());
            funciionario.setCpf(updateFuncionairo.getCpf());
            funciionario.setFuncao(updateFuncionairo.getFuncao());
            repository.save(funciionario);
            return Optional.of(funciionario);
        }
        return Optional.empty();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
