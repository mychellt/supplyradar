package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Permissao extends AbstractDomainObject<UUID> {
    private String sigla;
    private String nome;
    private String descricao;
    private TipoAtribuicao tipo;
    private Integer ordem;
}
