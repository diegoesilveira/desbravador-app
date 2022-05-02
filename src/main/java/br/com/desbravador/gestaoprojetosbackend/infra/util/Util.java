package br.com.desbravador.gestaoprojetosbackend.infra.util;

import java.util.Objects;

public final class Util {

    private Util() {
    }

    public static String validIsNull(Object value) {
        if (Objects.isNull(value))
            return null;
        return value.toString();
    }
}

