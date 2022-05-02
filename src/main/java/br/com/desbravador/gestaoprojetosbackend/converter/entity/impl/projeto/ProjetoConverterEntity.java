package br.com.desbravador.gestaoprojetosbackend.converter.entity.impl.projeto;

import br.com.desbravador.gestaoprojetosbackend.converter.entity.ConverterEntity;
import br.com.desbravador.gestaoprojetosbackend.domain.projeto.Projeto;
import br.com.desbravador.gestaoprojetosbackend.repository.entities.pessoa.PessoaEntity;
import br.com.desbravador.gestaoprojetosbackend.repository.entities.projeto.ProjetoEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProjetoConverterEntity implements ConverterEntity<ProjetoEntity, Projeto> {

    @Override
    public Optional<ProjetoEntity> convertToEntity(Optional<Projeto> domain) {
        if(domain.isEmpty()) {
            return Optional.empty();
        }

        var projeto = domain.orElseGet(Projeto::new);
        var projetoEntity = convertToProjetoEntity(projeto);
        return Optional.of(projetoEntity);
    }

    @Override
    public Optional<Projeto> convertToDomain(Optional<ProjetoEntity> entity) {
        if (entity.isEmpty()) {
            return Optional.empty();
        }
        var projetoEntity = entity.orElseGet(ProjetoEntity::new);
        var projeto = convertToProjetoDomain(projetoEntity);
        return Optional.of(projeto);
    }

    private Projeto convertToProjetoDomain(ProjetoEntity projetoEntity) {
        return Projeto.builder()
                .id(projetoEntity.getId())
                .nome(projetoEntity.getNome())
                .dataInicio(projetoEntity.getDataInicio())
                .dataPrevisaoFim(projetoEntity.getDataPrevisaoFim())
                .dataFim(projetoEntity.getDataFim())
                .descricao(projetoEntity.getDescricao())
                .status(projetoEntity.getStatus())
                .risco(projetoEntity.getRisco())
                .orcamento(projetoEntity.getOrcamento())
                .idGerente(projetoEntity.getIdGerente().getId())
                .build();

    }

    private ProjetoEntity convertToProjetoEntity(Projeto projeto) {
        return  ProjetoEntity.builder()
                .id(projeto.getId())
                .nome(projeto.getNome())
                .dataInicio(projeto.getDataInicio())
                .dataPrevisaoFim(projeto.getDataPrevisaoFim())
                .dataFim(projeto.getDataFim())
                .descricao(projeto.getDescricao())
                .status(projeto.getStatus())
                .risco(projeto.getRisco())
                .orcamento(projeto.getOrcamento())
                .idGerente(pessoaEntity(projeto))
                .build();

    }

    private PessoaEntity pessoaEntity(Projeto projeto){
        return PessoaEntity.builder()
                .id(projeto.getIdGerente())
                .build();
    }
}
