package br.com.desbravador.gestaoprojetosbackend.converter.entity.impl.membro;

import br.com.desbravador.gestaoprojetosbackend.converter.entity.ConverterEntity;
import br.com.desbravador.gestaoprojetosbackend.domain.membro.Membro;
import br.com.desbravador.gestaoprojetosbackend.repository.entities.membro.MembroEntity;
import br.com.desbravador.gestaoprojetosbackend.repository.entities.membro.MembroEntityPK;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class MembroConverterEntity implements ConverterEntity<MembroEntity, Membro> {


    @Override
    public Optional<MembroEntity> convertToEntity(Optional<Membro> domain) {

        if (domain.isEmpty())
            return Optional.empty();


        var membro = domain.orElseGet(Membro::new);

        return Optional.of(MembroEntity.builder()
                .id(MembroEntityPK.builder()
                        .idProjeto(membro.getIdProjeto())
                        .idPessoa(membro.getIdPessoa())
                        .build())
                .build());
    }

    @Override
    public Optional<Membro> convertToDomain(Optional<MembroEntity> entity) {

        if (entity.isEmpty())
            return Optional.empty();

        var membroEntity = entity.orElseGet(MembroEntity::new);

        return Optional.of(Membro.builder()
                .idPessoa(membroEntity.getIdPessoa().getId())
                .idProjeto(membroEntity.getIdProjeto().getId())
                .build());
    }
}
