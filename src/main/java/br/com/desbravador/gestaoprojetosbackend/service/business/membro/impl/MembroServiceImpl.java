package br.com.desbravador.gestaoprojetosbackend.service.business.membro.impl;

import br.com.desbravador.gestaoprojetosbackend.domain.membro.Membro;
import br.com.desbravador.gestaoprojetosbackend.service.business.membro.MembroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MembroServiceImpl implements MembroService {

    @Override
    public Membro findById(Long id) {
        return null;
    }

    @Override
    public Membro save(Membro membro) {
        return null;
    }

    @Override
    public Membro update(Membro membro) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Membro> findAll() {
        return null;
    }
}
