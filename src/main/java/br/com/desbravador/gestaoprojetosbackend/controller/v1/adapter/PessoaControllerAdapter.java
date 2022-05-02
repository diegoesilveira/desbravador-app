package br.com.desbravador.gestaoprojetosbackend.controller.v1.adapter;

import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.pessoa.PessoaDto;

import java.util.List;

public interface PessoaControllerAdapter {

    PessoaDto save(PessoaDto pessoaDto);

    PessoaDto update(PessoaDto payload);

    void delete(Long id);

    PessoaDto findById(Long id);

    List<PessoaDto> findAll();
}
