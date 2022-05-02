package br.com.desbravador.gestaoprojetosbackend.service.business.projeto;

import br.com.desbravador.gestaoprojetosbackend.domain.projeto.Projeto;

import java.util.List;

public interface ProjetoService {

    Projeto save(Projeto projeto);

    Projeto update(Projeto projeto);

    Projeto findById(Long id);

    void delete(Long id);

    List<Projeto> findAllProjeto();
}
