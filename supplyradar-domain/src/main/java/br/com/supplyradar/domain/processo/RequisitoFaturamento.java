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
public class RequisitoFaturamento extends AbstractDomainObject<UUID> implements Visitable<RequisitoFaturamento> {
	private String denominacao;
	private String descricao;

	@Override
	public void accept(final Visitor<RequisitoFaturamento, ?> visitor) {
		visitor.visit(this);
	}
}
