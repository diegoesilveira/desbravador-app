package br.com.desbravador.gestaoprojetosbackend.controller.v1.adapter;

import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.projeto.ProjetoDto;

import java.util.List;

public interface ProjetosControllerAdapter {

    ProjetoDto save(ProjetoDto projetoDto);

    ProjetoDto update(ProjetoDto payload);

    void delete(Long id);

    ProjetoDto findById(Long id);

    List<ProjetoDto> findAll();
}
