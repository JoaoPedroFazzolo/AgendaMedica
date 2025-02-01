package com.agendamedica.service;


import com.agendamedica.entity.*;
import com.agendamedica.repository.FuncionarioRepository;
import com.agendamedica.repository.PacienteRepository;
import com.agendamedica.repository.UsuarioRepository;
import com.agendamedica.repository.MedicoRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final MedicoRepository medicoRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final PacienteRepository pacienteRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, MedicoRepository medicoRepository,
                          FuncionarioRepository funcionarioRepository, PacienteRepository pacienteRepository) {
        this.usuarioRepository = usuarioRepository;
        this.medicoRepository = medicoRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.pacienteRepository = pacienteRepository;
    }

    private <T> T criarEAdicionarEntidade(T entity, CrudRepository<T, Long> repository) {
        repository.save(entity);
        return entity;
    }


    @Transactional
    public UsuarioModel criarUsuario(UsuarioModel usuarioModel) {
        if (usuarioModel.getTipoUsuario() == TipoUsuario.MEDICO) {
            criarEAdicionarEntidade(usuarioModel.getMedico(), medicoRepository);
        } else if (usuarioModel.getTipoUsuario() == TipoUsuario.PACIENTE) {
            criarEAdicionarEntidade(usuarioModel.getPaciente(), pacienteRepository);
        } else if (usuarioModel.getTipoUsuario() == TipoUsuario.FUNCIONARIO) {
            criarEAdicionarEntidade(usuarioModel.getFuncionario(), funcionarioRepository);
        }
        return usuarioRepository.save(usuarioModel);
    }
}
