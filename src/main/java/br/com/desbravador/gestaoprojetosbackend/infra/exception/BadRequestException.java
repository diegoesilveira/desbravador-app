package br.com.desbravador.gestaoprojetosbackend.infra.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(final String msg) {
        super(msg);
    }
}
