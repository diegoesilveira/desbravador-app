package br.com.desbravador.gestaoprojetosbackend.converter.entity.impl.pessoa;

import br.com.desbravador.gestaoprojetosbackend.converter.entity.ConverterEntity;
import br.com.desbravador.gestaoprojetosbackend.domain.pessoa.Pessoa;
import br.com.desbravador.gestaoprojetosbackend.repository.entities.pessoa.PessoaEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PessoaConverterEntity implements ConverterEntity<PessoaEntity, Pessoa> {

    @Override
    public Optional<PessoaEntity> convertToEntity(Optional<Pessoa> domain) {
        if(domain.isEmpty()) {
            return Optional.empty();
        }

        var pessoa = domain.orElseGet(Pessoa::new);
        var pessoaEntity = convertToPessoaEntity(pessoa);
        return Optional.of(pessoaEntity);
    }

    @Override
    public Optional<Pessoa> convertToDomain(Optional<PessoaEntity> entity) {
        if (entity.isEmpty()) {
            return Optional.empty();
        }
        var pessoaoEntity = entity.orElseGet(PessoaEntity::new);
        var projeto = convertToPessoaDomain(pessoaoEntity);
        return Optional.of(projeto);
    }

    private Pessoa convertToPessoaDomain(PessoaEntity pessoaEntity) {
        return Pessoa.builder()
                .id(pessoaEntity.getId())
                .nome(pessoaEntity.getNome())
                .cpf(pessoaEntity.getCpf())
                .dataNascimento(pessoaEntity.getDataNascimento())
                .funcionario(pessoaEntity.getFuncionario())
                .build();

    }

    private PessoaEntity convertToPessoaEntity(Pessoa pessoa) {
        return  PessoaEntity.builder()
                .id(pessoa.getId())
                .cpf(pessoa.getCpf())
                .nome(pessoa.getNome())
                .dataNascimento(pessoa.getDataNascimento())
                .funcionario(pessoa.getFuncionario())
                .build();

    }
}
