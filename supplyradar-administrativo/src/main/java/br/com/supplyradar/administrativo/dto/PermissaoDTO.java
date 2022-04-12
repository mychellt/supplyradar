package br.com.supplyradar.administrativo.dto;

import br.com.supplyradar.domain.commons.TipoAtribuicao;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;


@Data
@ToString
public class PermissaoDTO {
    private String sigla;
    private String nome;
    private String descricao;
    private TipoAtribuicao tipo;
    private Integer ordem;
    private UUID id;
}
