package br.com.desbravador.gestaoprojetosbackend.service.handler.impl;

import br.com.desbravador.gestaoprojetosbackend.domain.membro.Membro;
import br.com.desbravador.gestaoprojetosbackend.domain.pessoa.Pessoa;
import br.com.desbravador.gestaoprojetosbackend.domain.projeto.Projeto;
import br.com.desbravador.gestaoprojetosbackend.service.business.membro.MembroService;
import br.com.desbravador.gestaoprojetosbackend.service.business.pessoa.PessoaService;
import br.com.desbravador.gestaoprojetosbackend.service.business.projeto.ProjetoService;
import br.com.desbravador.gestaoprojetosbackend.service.handler.ServiceHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("ServiceHandlerImpl")
@AllArgsConstructor
public class ServiceHandlerImpl implements ServiceHandler {

    private final ProjetoService service;
    private final PessoaService servicePessoa;
    private final MembroService membroService;


    @Override
    public Projeto saveProjeto(Projeto projeto) {
        return service.save(projeto);
    }

    @Override
    public Projeto updateProjeto(Projeto projeto) {
        return service.update(projeto);
    }

    @Override
    public Projeto findByIdProjeto(Long id) {
        return service.findById(id);
    }

    @Override
    public List<Projeto> findAllProjeto() {
        return service.findAllProjeto();
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }

    @Override
    public Pessoa savePessoa(Pessoa pessoa) {
        return servicePessoa.save(pessoa);
    }

    @Override
    public Pessoa updatePessoa(Pessoa pessoa) {
        return servicePessoa.update(pessoa);
    }

    @Override
    public Pessoa findByIdPessoa(Long id) {
        return servicePessoa.findById(id);
    }

    @Override
    public List<Pessoa> findAllPessoa() {
        return servicePessoa.findAllPessoa();
    }

    @Override
    public Membro saveMembro(Membro membro) {
        return membroService.save(membro);
    }

    @Override
    public Membro updateMembro(Membro membro) {
        return null;
    }

    @Override
    public Membro findByIdMembro(Long id) {
        return null;
    }

    @Override
    public List<Membro> findAllMembro() {
        return null;
    }


}
