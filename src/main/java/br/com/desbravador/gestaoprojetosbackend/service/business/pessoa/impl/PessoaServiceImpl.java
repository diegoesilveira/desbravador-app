package br.com.desbravador.gestaoprojetosbackend.service.business.pessoa.impl;

import br.com.desbravador.gestaoprojetosbackend.converter.entity.impl.pessoa.PessoaConverterEntity;
import br.com.desbravador.gestaoprojetosbackend.domain.pessoa.Pessoa;
import br.com.desbravador.gestaoprojetosbackend.repository.entities.pessoa.PessoaEntity;
import br.com.desbravador.gestaoprojetosbackend.repository.repositories.pessoa.PessoaRepository;
import br.com.desbravador.gestaoprojetosbackend.service.business.pessoa.PessoaService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static br.com.desbravador.gestaoprojetosbackend.infra.util.Constants.LOGGER;

@AllArgsConstructor
@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository repository;
    private final Logger logger = LoggerFactory.getLogger(LOGGER);

    @Override
    public Pessoa findById(Long id) {
        PessoaEntity entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrado"));

        return new PessoaConverterEntity().convertToDomainNotOptional(entity);
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        logger.info("Preparando para salvar pessoa");

        PessoaEntity pessoaEntity = new PessoaConverterEntity().convertToEntityNotOptional(pessoa);
        var saved = repository.save(pessoaEntity);
        logger.info("Pessoa salvo com sucesso");

        return  new PessoaConverterEntity().convertToDomainNotOptional(saved);
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        logger.info("Preparando para atualizar o id: " +pessoa.getId());

        var pessoaById = findById(pessoa.getId());

        pessoaById.setNome(pessoa.getNome());
        pessoaById.setCpf(pessoa.getCpf());
        pessoaById.setDataNascimento(pessoa.getDataNascimento());
        pessoaById.setFuncionario(pessoa.getFuncionario());

        PessoaEntity pessoaEntity = new PessoaConverterEntity().convertToEntityNotOptional(pessoaById);

        return new PessoaConverterEntity().convertToDomainNotOptional(repository.save(pessoaEntity));
    }

    @Override
    public void delete(Long id) {
        logger.info("Preparando para deletar o id: " +id);

        Pessoa byId = findById(id);
        var entity = new PessoaConverterEntity().convertToEntityNotOptional(byId);
        repository.delete(entity);
    }

    @Override
    public List<Pessoa> findAllPessoa() {
        return new PessoaConverterEntity().convertToDomains(repository.findAll());
    }
}
