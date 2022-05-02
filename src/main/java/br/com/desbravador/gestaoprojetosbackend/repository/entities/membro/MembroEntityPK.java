package br.com.desbravador.gestaoprojetosbackend.repository.entities.membro;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MembroEntityPK implements Serializable {

    @Column(name = "id_projeto_fk")
    private Long idProjeto;

    @Column(name = "id_pessoa_fk")
    private Long idPessoa;
}
