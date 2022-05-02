package br.com.desbravador.gestaoprojetosbackend.controller.v1.adapter.impl.membro;

import br.com.desbravador.gestaoprojetosbackend.controller.v1.adapter.MembroControllerAdapter;
import br.com.desbravador.gestaoprojetosbackend.controller.v1.adapter.PessoaControllerAdapter;
import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.membro.MembrosDto;
import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.pessoa.PessoaDto;
import br.com.desbravador.gestaoprojetosbackend.converter.dto.ConverterDto;
import br.com.desbravador.gestaoprojetosbackend.domain.membro.Membro;
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
public class MembroControllerAdapterImpl implements MembroControllerAdapter {

    private final ServiceHandler handler;
    private final ConverterDto<MembrosDto, Membro> converter;


    @Override
    public MembrosDto save(MembrosDto membrosDto) {
        var membro = converter.convertToDomain(membrosDto)
                .orElseThrow(() -> new ConverterErrorException("Error converter to domain"));
        return converter.convertToDtoNotOptional(handler.saveMembro(membro));
    }

    @Override
    public MembrosDto update(MembrosDto payload) {
        return converter.convertToDtoNotOptional(handler.updateMembro(converter.convertToDomainNotOptional(payload)));
    }

    @Override
    public void delete(Long id) {
        handler.delete(id);
    }

    @Override
    public MembrosDto findById(Long id) {
        return converter.convertToDtoNotOptional(handler.findByIdMembro(id));
    }

    @Override
    public List<MembrosDto> findAll() {
        return converter.convertToDtos(handler.findAllMembro());
    }
}
