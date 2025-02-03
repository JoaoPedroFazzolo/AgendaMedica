package com.agendamedica.exception;

public class UsernameOrPasswordInvalidException extends RuntimeException {
    public UsernameOrPasswordInvalidException(String mensagem) {
        super(mensagem);

    }
}
