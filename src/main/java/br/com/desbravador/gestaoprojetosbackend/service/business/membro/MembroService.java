package br.com.desbravador.gestaoprojetosbackend.service.business.membro;

import br.com.desbravador.gestaoprojetosbackend.domain.membro.Membro;

import java.util.List;

public interface MembroService {

    Membro findById(Long id);

    Membro save(Membro membro);

    Membro update(Membro membro);

    void delete(Long id);

    List<Membro> findAll();
}
