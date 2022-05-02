package br.com.desbravador.gestaoprojetosbackend.converter.dto.impl.membro;

import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.membro.MembrosDto;
import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.pessoa.PessoaDto;
import br.com.desbravador.gestaoprojetosbackend.converter.dto.ConverterDto;
import br.com.desbravador.gestaoprojetosbackend.domain.membro.Membro;
import br.com.desbravador.gestaoprojetosbackend.domain.pessoa.Pessoa;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MembroConverterDto implements ConverterDto<MembrosDto, Membro> {


    @Override
    public Optional<MembrosDto> convertToDto(Optional<Membro> domain) {

        if (domain.isEmpty()) {
            return Optional.empty();
        }

        var pessoa = domain.orElseGet(Membro::new);
        var pessoaDto = converterToMembroDto(pessoa);
        return Optional.of(pessoaDto);
    }

    @Override
    public Optional<Membro> convertToDomain(Optional<MembrosDto> dto) {
        if (dto.isEmpty()) {
            return Optional.empty();
        }

        var membroDto = dto.orElseGet(MembrosDto::new);
        var membro = convertToMembroDomain(membroDto);

        return Optional.of(membro);
    }

    private Membro convertToMembroDomain(MembrosDto membrosDto) {
        return Membro.builder()
                .idPessoa(membrosDto.getIdPessoa())
                .idProjeto(membrosDto.getIdProjeto())
                .build();

    }

    private MembrosDto converterToMembroDto(Membro membro) {
       return MembrosDto.builder()
               .idPessoa(membro.getIdPessoa())
               .idProjeto(membro.getIdProjeto())
               .build();
    }

}
