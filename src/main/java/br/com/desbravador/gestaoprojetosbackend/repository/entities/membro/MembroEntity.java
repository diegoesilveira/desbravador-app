package br.com.desbravador.gestaoprojetosbackend.repository.entities.membro;

import br.com.desbravador.gestaoprojetosbackend.repository.entities.pessoa.PessoaEntity;
import br.com.desbravador.gestaoprojetosbackend.repository.entities.projeto.ProjetoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "membros")
public class MembroEntity implements Serializable {

    @EmbeddedId
    private MembroEntityPK id;

    @ManyToOne
    @MapsId("fk_membros_pessoa")
    @JoinColumn(name = "idProjeto", insertable = false, updatable = false)
    private ProjetoEntity idProjeto;

    @ManyToOne
    @MapsId("fk_pessoa")
    @JoinColumn(name = "idPessoa", insertable = false, updatable = false)
    private PessoaEntity idPessoa;
}
