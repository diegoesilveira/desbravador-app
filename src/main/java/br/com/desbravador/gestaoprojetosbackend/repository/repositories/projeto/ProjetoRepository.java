package br.com.desbravador.gestaoprojetosbackend.repository.repositories.projeto;

import br.com.desbravador.gestaoprojetosbackend.repository.entities.projeto.ProjetoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<ProjetoEntity, Long> {
}
