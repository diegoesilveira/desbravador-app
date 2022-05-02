package br.com.desbravador.gestaoprojetosbackend.converter.dto.impl.projeto;

import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.enums.EnumRiscoDto;
import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.enums.EnumStatusDto;
import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.projeto.ProjetoDto;
import br.com.desbravador.gestaoprojetosbackend.converter.dto.ConverterDto;
import br.com.desbravador.gestaoprojetosbackend.domain.projeto.Projeto;
import br.com.desbravador.gestaoprojetosbackend.infra.util.Util;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class ProjetoConverterDto implements ConverterDto<ProjetoDto, Projeto> {


    @Override
    public Optional<ProjetoDto> convertToDto(Optional<Projeto> domain) {

        if (domain.isEmpty()) {
            return Optional.empty();
        }

        var projeto = domain.orElseGet(Projeto::new);
        var projetoDto = converterToProjetoDto(projeto);
        return Optional.of(projetoDto);
    }

    @Override
    public Optional<Projeto> convertToDomain(Optional<ProjetoDto> dto) {
        if (dto.isEmpty()) {
            return Optional.empty();
        }

        var projetoDto = dto.orElseGet(ProjetoDto::new);
        var projeto = convertToProjetoDomain(projetoDto);

        return Optional.of(projeto);
    }

    private Projeto convertToProjetoDomain(ProjetoDto projetoDto) {
        return Projeto.builder()
                .id(projetoDto.getId())
                .nome(projetoDto.getNome())
                .dataInicio(projetoDto.getDataInicio())
                .dataPrevisaoFim(projetoDto.getDataPrevisaoFim())
                .dataFim(projetoDto.getDataFim())
                .descricao(projetoDto.getDescricao())
                .status(Util.validIsNull(projetoDto.getStatus()))
                .risco(Util.validIsNull(projetoDto.getRisco()))
                .orcamento(projetoDto.getOrcamento())
                .idGerente(projetoDto.getIdGerente())
                .build();

    }

    private ProjetoDto converterToProjetoDto(Projeto projeto) {
       return ProjetoDto.builder()
                .id(projeto.getId())
                .nome(projeto.getNome())
                .dataInicio(projeto.getDataInicio())
                .dataPrevisaoFim(projeto.getDataPrevisaoFim())
                .dataFim(projeto.getDataFim())
                .descricao(projeto.getDescricao())
                .status(validStringExistsStatus(projeto.getStatus()))
                .risco(validStringExistsRisco(projeto.getRisco()))
                .orcamento(projeto.getOrcamento())
                .idGerente(projeto.getIdGerente())
                .build();
    }

    private EnumRiscoDto validStringExistsRisco(String value) {
        return Objects.isNull(value) ? null : EnumRiscoDto.valueOf(value.toUpperCase());
    }

    private EnumStatusDto validStringExistsStatus(String value){
        return Objects.isNull(value) ? null : EnumStatusDto.valueOf(value.toUpperCase());
    }
}
