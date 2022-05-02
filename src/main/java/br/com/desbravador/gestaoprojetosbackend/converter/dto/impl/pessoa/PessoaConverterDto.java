package br.com.desbravador.gestaoprojetosbackend.converter.dto.impl.pessoa;

import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.pessoa.PessoaDto;
import br.com.desbravador.gestaoprojetosbackend.converter.dto.ConverterDto;
import br.com.desbravador.gestaoprojetosbackend.domain.pessoa.Pessoa;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PessoaConverterDto implements ConverterDto<PessoaDto, Pessoa> {


    @Override
    public Optional<PessoaDto> convertToDto(Optional<Pessoa> domain) {

        if (domain.isEmpty()) {
            return Optional.empty();
        }

        var pessoa = domain.orElseGet(Pessoa::new);
        var pessoaDto = converterToPessoaDto(pessoa);
        return Optional.of(pessoaDto);
    }

    @Override
    public Optional<Pessoa> convertToDomain(Optional<PessoaDto> dto) {
        if (dto.isEmpty()) {
            return Optional.empty();
        }

        var pessoaDto = dto.orElseGet(PessoaDto::new);
        var pessoa = convertToPessoaDomain(pessoaDto);

        return Optional.of(pessoa);
    }

    private Pessoa convertToPessoaDomain(PessoaDto pessoaDto) {
        return Pessoa.builder()
                .nome(pessoaDto.getNome())
                .id(pessoaDto.getId())
                .funcionario(pessoaDto.getFuncionario())
                .cpf(pessoaDto.getCpf())
                .dataNascimento(pessoaDto.getDataNascimento())
                .build();

    }

    private PessoaDto converterToPessoaDto(Pessoa pessoa) {
       return PessoaDto.builder()
               .nome(pessoa.getNome())
               .id(pessoa.getId())
               .cpf(pessoa.getCpf())
               .funcionario(pessoa.getFuncionario())
               .dataNascimento(pessoa.getDataNascimento())
               .build();
    }

}
