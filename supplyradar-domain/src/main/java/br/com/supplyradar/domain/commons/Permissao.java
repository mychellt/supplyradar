package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Permissao extends AbstractDomainObject<UUID> implements Visitable<Permissao> {
    private String sigla;
    private String nome;
    private String descricao;
    private TipoAtribuicao tipo;
    private Integer ordem;

    @Override
    public void accept(Visitor<Permissao, ?> visitor) {
        visitor.visit(this);
    }
}
