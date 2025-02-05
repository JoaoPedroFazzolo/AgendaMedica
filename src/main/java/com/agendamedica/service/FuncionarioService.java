package com.agendamedica.service;

import com.agendamedica.entity.FuncionarioModel;
import com.agendamedica.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public List<FuncionarioModel> listar() {
        log.info("Listando todos os funcionarios");
        return repository.findAll();
    }

    public FuncionarioModel salvar(FuncionarioModel funcionario) {
        log.info("Salvando funcionario {}", funcionario);
        return repository.save(funcionario);
    }

    public Optional<FuncionarioModel> buscarPorId(Long id) {
        log.info("Buscando funcionario por id {}", id);
        return repository.findById(id);
    }

    public Optional<FuncionarioModel> atualizar(Long id, FuncionarioModel updateFuncionairo) {
        Optional<FuncionarioModel> optionalFuncionario = repository.findById(id);
        log.info("Atualizando funcionario {}", updateFuncionairo);
        if (optionalFuncionario.isPresent()) {
            FuncionarioModel funciionario = optionalFuncionario.get();
            funciionario.setNome(updateFuncionairo.getNome());
            funciionario.setCpf(updateFuncionairo.getCpf());
            funciionario.setFuncao(updateFuncionairo.getFuncao());
            repository.save(funciionario);
            log.info("Funcionario atualizado com sucesso");
            return Optional.of(funciionario);
        }
        log.info("Funcionario não encontrado");
        return Optional.empty();
    }

    public void excluir(Long id) {
        log.info("Excluindo funcionario {}", id);
        repository.deleteById(id);
    }
}
