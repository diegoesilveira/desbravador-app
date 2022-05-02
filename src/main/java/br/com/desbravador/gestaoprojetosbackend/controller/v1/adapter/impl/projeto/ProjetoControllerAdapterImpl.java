package br.com.desbravador.gestaoprojetosbackend.controller.v1.adapter.impl.projeto;

import br.com.desbravador.gestaoprojetosbackend.controller.v1.adapter.ProjetosControllerAdapter;
import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.projeto.ProjetoDto;
import br.com.desbravador.gestaoprojetosbackend.converter.dto.ConverterDto;
import br.com.desbravador.gestaoprojetosbackend.domain.projeto.Projeto;
import br.com.desbravador.gestaoprojetosbackend.infra.exception.ConverterErrorException;
import br.com.desbravador.gestaoprojetosbackend.service.handler.ServiceHandler;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class ProjetoControllerAdapterImpl implements ProjetosControllerAdapter {

    private final ServiceHandler handler;
    private final ConverterDto<ProjetoDto, Projeto> converter;

    @Override
    public ProjetoDto save(ProjetoDto projetoDto) {

        var projeto = converter.convertToDomain(projetoDto)
                .orElseThrow(() -> new ConverterErrorException("Error converter to domain"));
        return converter.convertToDtoNotOptional(handler.saveProjeto(projeto));
    }

    @Override
    public ProjetoDto update(ProjetoDto payload) {

        return converter.convertToDtoNotOptional(handler.updateProjeto(converter.convertToDomainNotOptional(payload)));
    }

    @Override
    public void delete(Long id) {
        handler.delete(id);

    }

    @Override
    public ProjetoDto findById(Long id) {
        return converter.convertToDtoNotOptional(handler.findByIdProjeto(id));
    }

    @Override
    public List<ProjetoDto> findAll() {
        return converter.convertToDtos(handler.findAllProjeto());
    }


}
