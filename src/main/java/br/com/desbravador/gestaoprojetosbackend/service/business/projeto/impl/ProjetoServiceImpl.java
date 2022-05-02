package br.com.desbravador.gestaoprojetosbackend.service.business.projeto.impl;

import br.com.desbravador.gestaoprojetosbackend.converter.entity.impl.projeto.ProjetoConverterEntity;
import br.com.desbravador.gestaoprojetosbackend.domain.projeto.Projeto;
import br.com.desbravador.gestaoprojetosbackend.infra.exception.ProjetoExclusionException;
import br.com.desbravador.gestaoprojetosbackend.repository.entities.projeto.ProjetoEntity;
import br.com.desbravador.gestaoprojetosbackend.repository.repositories.projeto.ProjetoRepository;
import br.com.desbravador.gestaoprojetosbackend.service.business.pessoa.PessoaService;
import br.com.desbravador.gestaoprojetosbackend.service.business.projeto.ProjetoService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.enums.EnumStatusDto.INICIADO;
import static br.com.desbravador.gestaoprojetosbackend.infra.util.Constants.LOGGER;

@AllArgsConstructor
@Service
public class ProjetoServiceImpl implements ProjetoService {

    private final ProjetoRepository repository;
    private final PessoaService pessoaService;
    private final Logger logger = LoggerFactory.getLogger(LOGGER);

    @Override
    public Projeto save(Projeto projeto) {
        logger.info("Preparando para Salvar o projeto");

//      var pessoa = pessoaService.findById(projeto.getIdGerente());

        var projetoEntity = new ProjetoConverterEntity().convertToEntityNotOptional(projeto);

        var saved = repository.save(projetoEntity);

        logger.info("Projeto salvo com sucesso");
        return new ProjetoConverterEntity().convertToDomainNotOptional(saved);
    }

    @Override
    public Projeto update(Projeto projeto) {
        var byId = findById(projeto.getId());

        byId.setNome(projeto.getNome());
        byId.setDescricao(projeto.getDescricao());
        byId.setDataFim(projeto.getDataFim());
        byId.setDataInicio(projeto.getDataInicio());
        byId.setOrcamento(projeto.getOrcamento());
        byId.setRisco(projeto.getRisco());
        byId.setStatus(projeto.getStatus());
        byId.setIdGerente(projeto.getIdGerente());

        ProjetoEntity projetoEntity = new ProjetoConverterEntity().convertToEntityNotOptional(byId);
        return new ProjetoConverterEntity().convertToDomainNotOptional(repository.save(projetoEntity));
    }

    @Override
    public Projeto findById(Long id) {

        ProjetoEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Projeto não encontrado"));
        return new ProjetoConverterEntity().convertToDomainNotOptional(entity);
    }

    @Override
    public void delete(Long id) {

        validaExclusaoProjeto(id);
        var entity = new ProjetoConverterEntity().convertToEntityNotOptional(findById(id));
        repository.delete(entity);
    }

    private void validaExclusaoProjeto(Long id) {
        String status = findById(id).getStatus();

        if (status.equals(INICIADO))  {
            throw new ProjetoExclusionException("Projeto não pode ser excluido, status INICIADO, EM_ANDAMENTO e ENCERRADO não é possivel a exclusao");
        }
    }

    @Override
    public List<Projeto> findAllProjeto() {
        return new ProjetoConverterEntity().convertToDomains(repository.findAll());
    }


}
