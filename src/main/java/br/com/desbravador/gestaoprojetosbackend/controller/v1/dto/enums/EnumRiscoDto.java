package br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.enums;

public enum EnumRiscoDto {

    BAIXO_RISCO("BAIXO_RISCO"),
    MEDIO_RISCO("MEDIO_RISCO"),
    ALTO_RISCO("ALTO_RISCO");

    private final String description;

    EnumRiscoDto(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
