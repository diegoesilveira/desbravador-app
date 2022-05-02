package br.com.desbravador.gestaoprojetosbackend.infra.exception;

public class ConverterErrorException extends RuntimeException {

    public ConverterErrorException(final String msg) {
        super(msg);
    }
}
