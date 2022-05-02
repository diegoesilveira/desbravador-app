package br.com.desbravador.gestaoprojetosbackend.repository.repositories.pessoa;

import br.com.desbravador.gestaoprojetosbackend.repository.entities.pessoa.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
}
