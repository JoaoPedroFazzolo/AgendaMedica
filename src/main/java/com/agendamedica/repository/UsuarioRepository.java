package com.agendamedica.repository;

import com.agendamedica.entity.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long> {

    Optional<UserDetails> findUsuarioModelByEmail(String email);
}
