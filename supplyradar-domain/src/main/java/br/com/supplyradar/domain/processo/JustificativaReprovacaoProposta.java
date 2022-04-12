package br.com.supplyradar.domain.processo;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JustificativaReprovacaoProposta extends AbstractDomainObject<UUID> implements Visitable<JustificativaReprovacaoProposta> {
	private String descricao;

	@Override
	public void accept(Visitor<JustificativaReprovacaoProposta, ?> visitor) {
		visitor.visit(this);
	}
}
