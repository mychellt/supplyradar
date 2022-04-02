package br.supplyradar.administrativo.dto;

import br.com.supplyradar.domain.commons.TipoAtribuicao;
import lombok.Data;


@Data
public class PermissaoDTO {
    private String sigla;
    private String nome;
    private String descricao;
    private TipoAtribuicao tipo;
    private Integer ordem;
}
