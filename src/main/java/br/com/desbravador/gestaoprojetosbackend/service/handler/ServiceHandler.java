package br.com.desbravador.gestaoprojetosbackend.service.handler;

import br.com.desbravador.gestaoprojetosbackend.domain.membro.Membro;
import br.com.desbravador.gestaoprojetosbackend.domain.pessoa.Pessoa;
import br.com.desbravador.gestaoprojetosbackend.domain.projeto.Projeto;

import java.util.List;

public interface ServiceHandler {

    Projeto saveProjeto(Projeto projeto);

    Projeto updateProjeto(Projeto projeto);

    Projeto findByIdProjeto(Long id);

    List<Projeto> findAllProjeto();

    void delete(Long id);

    Pessoa savePessoa(Pessoa pessoa);

    Pessoa updatePessoa(Pessoa pessoa);

    Pessoa findByIdPessoa(Long id);

    List<Pessoa> findAllPessoa();

    Membro saveMembro(Membro membro);

    Membro updateMembro(Membro membro);

    Membro findByIdMembro(Long id);

    List<Membro> findAllMembro();

}
