package br.com.desbravador.gestaoprojetosbackend.controller.v1.adapter;

import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.membro.MembrosDto;

import java.util.List;

public interface MembroControllerAdapter {

    MembrosDto save(MembrosDto membrosDto);

    MembrosDto update(MembrosDto membrosDto);

    void delete(Long id);

    MembrosDto findById(Long id);

    List<MembrosDto> findAll();
}
