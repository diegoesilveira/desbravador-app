package br.com.desbravador.gestaoprojetosbackend.infra.exception;

public class NotEnumException extends RuntimeException {

    public NotEnumException(final String msg) {
        super(msg);
    }
}
