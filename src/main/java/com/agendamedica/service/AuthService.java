package com.agendamedica.service;

import com.agendamedica.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Iniciando a busca do usuario pelo email");
        log.info("Usuario encontrado: " + email);
        return usuarioRepository.findUsuarioModelByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário ou senha inválidos"));
    }
}
