package com.agendamedica.config;

import com.agendamedica.entity.UsuarioModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;

@Component
public class TokenService {
    @Value("${agendamedica.security.secret}")
    private String secret;

    public String generateToken(UsuarioModel usuarioModel) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withSubject(usuarioModel.getEmail())
                .withClaim("userId", usuarioModel.getId())
                .withClaim("userEmail", usuarioModel.getEmail())
                .withClaim("tipoUsuario", usuarioModel.getTipoUsuario().toString())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API Agenda Medica")
                .sign(algorithm);
    }

    public Optional<JWTUserData> verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            DecodedJWT jwt = JWT.require(algorithm).build().verify(token);
            System.out.println("entrei no token");
            return Optional.of(JWTUserData.builder()
                    .id(jwt.getClaim("userId").asLong())
                    .email(jwt.getClaim("userEmail").asString()).build());
        }catch (JWTVerificationException e) {
            return Optional.empty();
        }


    }
}
