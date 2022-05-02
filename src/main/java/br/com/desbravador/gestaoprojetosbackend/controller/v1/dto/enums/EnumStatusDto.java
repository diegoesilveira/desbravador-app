package br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.enums;

public enum EnumStatusDto {

    EM_ANALISE("BAIXO_RISCO"),
    ANALISE_REALIZADA("ANALISE_REALIZADA"),
    ANALISE_APROVADA("ANALISE_APROVADA"),
    INICIADO("INICIADO"),
    PLANEJADO("PLANEJADO"),
    EM_ANDAMENTO("EM_ANDAMENTO"),
    ENCERRADO("ENCERRADO"),
    CANCELADO("CANCELADO");

    private final String description;

    EnumStatusDto(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
