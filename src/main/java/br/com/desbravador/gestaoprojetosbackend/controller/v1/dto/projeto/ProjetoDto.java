package br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.projeto;

import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.enums.EnumRiscoDto;
import br.com.desbravador.gestaoprojetosbackend.controller.v1.dto.enums.EnumStatusDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "Projeto", subTypes = {Object.class})
public class ProjetoDto implements Serializable {

    @ApiModelProperty(notes = "id projeto", dataType = "long", example = "0", position = 1)
    private Long id;

    @ApiModelProperty(notes = "Nome", dataType = "String", example = "Robert Kirkman", position = 2)
    private String nome;

    @ApiModelProperty(notes = "Data Inicio", dataType = "LocalDate", example = "1987-06-01", position = 3)
    private LocalDate dataInicio;

    @ApiModelProperty(notes = "Data Previsão fim", dataType = "LocalDate", example = "1987-06-01", position = 4)
    private LocalDate dataPrevisaoFim;

    @ApiModelProperty(notes = "Data Fim", dataType = "LocalDate", example = "1987-06-01", position = 5)
    private LocalDate dataFim;

    @ApiModelProperty(notes = "Descricao", dataType = "String", example = "Projeto Abc", position = 6)
    private String descricao;

    @ApiModelProperty(notes = "Status", dataType = "enum", example = "INICIADO", position = 7)
    private EnumStatusDto status = null;

    @ApiModelProperty(notes = "Orcamento", dataType = "Float", example = "1987-06-01", position = 8)
    private Float orcamento;

    @ApiModelProperty(notes = "risco", dataType = "Enum", example = "BAIXO_RISCO", position = 9)
    private EnumRiscoDto risco = null;

    @ApiModelProperty(notes = "Id Gerente", dataType = "Long", example = "1987-06-01", position = 10)
    private Long idGerente;
}
