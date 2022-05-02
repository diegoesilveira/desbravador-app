package br.com.desbravador.gestaoprojetosbackend.controller.v1.adapter.impl.pessoa;

import br.com.desbravador.gestaoprojetosbackend.controller.v1.adapter.PessoaControllerAdapter;
import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.pessoa.PessoaDto;
import br.com.desbravador.gestaoprojetosbackend.converter.dto.ConverterDto;
import br.com.desbravador.gestaoprojetosbackend.domain.pessoa.Pessoa;
import br.com.desbravador.gestaoprojetosbackend.infra.exception.ConverterErrorException;
import br.com.desbravador.gestaoprojetosbackend.service.handler.ServiceHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class PessoaControllerAdapterImpl implements PessoaControllerAdapter {

    private final ServiceHandler handler;
    private final ConverterDto<PessoaDto, Pessoa> converter;


    @Override
    public PessoaDto save(PessoaDto pessoaDto) {
        var pessoa = converter.convertToDomain(pessoaDto)
                .orElseThrow(() -> new ConverterErrorException("Error converter to domain"));
        return converter.convertToDtoNotOptional(handler.savePessoa(pessoa));
    }

    @Override
    public PessoaDto update(PessoaDto payload) {
        return converter.convertToDtoNotOptional(handler.updatePessoa(converter.convertToDomainNotOptional(payload)));
    }

    @Override
    public void delete(Long id) {
        handler.delete(id);
    }

    @Override
    public PessoaDto findById(Long id) {
        return converter.convertToDtoNotOptional(handler.findByIdPessoa(id));
    }

    @Override
    public List<PessoaDto> findAll() {
        return converter.convertToDtos(handler.findAllPessoa());
    }
}
