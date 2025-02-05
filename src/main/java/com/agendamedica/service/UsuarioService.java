package com.agendamedica.service;


import com.agendamedica.entity.*;
import com.agendamedica.repository.FuncionarioRepository;
import com.agendamedica.repository.PacienteRepository;
import com.agendamedica.repository.UsuarioRepository;
import com.agendamedica.repository.MedicoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final MedicoRepository medicoRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final PacienteRepository pacienteRepository;
    private final PasswordEncoder passwordEncoder;

    private <T> T criarEAdicionarEntidade(T entity, CrudRepository<T, Long> repository) {
        repository.save(entity);
        return entity;
    }


    @Transactional
    public UsuarioModel criarUsuario(UsuarioModel usuarioModel) {
        if (usuarioModel.getTipoUsuario() == TipoUsuario.MEDICO) {
            log.info("Criando usuario tipo medico");
            criarEAdicionarEntidade(usuarioModel.getMedico(), medicoRepository);
        } else if (usuarioModel.getTipoUsuario() == TipoUsuario.PACIENTE) {
            log.info("Criando usuario tipo paciente");
            criarEAdicionarEntidade(usuarioModel.getPaciente(), pacienteRepository);
        } else if (usuarioModel.getTipoUsuario() == TipoUsuario.FUNCIONARIO) {
            log.info("Criando usuario funcionario");
            criarEAdicionarEntidade(usuarioModel.getFuncionario(), funcionarioRepository);
        }
        String senha = usuarioModel.getSenha();
        log.info("codificando senha");
        usuarioModel.setSenha(passwordEncoder.encode(senha));
        log.info("Senha codificada com sucesso");
        log.info("Usuario criado com sucesso");
        return usuarioRepository.save(usuarioModel);
    }
}
