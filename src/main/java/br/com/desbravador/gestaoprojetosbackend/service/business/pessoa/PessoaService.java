package br.com.desbravador.gestaoprojetosbackend.service.business.pessoa;

import br.com.desbravador.gestaoprojetosbackend.domain.pessoa.Pessoa;

import java.util.List;

public interface PessoaService {

    Pessoa findById(Long id);

    Pessoa save(Pessoa pessoa);

    Pessoa update(Pessoa pessoa);

    void delete(Long id);

    List<Pessoa> findAllPessoa();
}
