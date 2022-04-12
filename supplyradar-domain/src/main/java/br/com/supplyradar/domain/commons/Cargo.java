package br.com.supplyradar.domain.commons;

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
public class Cargo extends AbstractDomainObject<UUID> implements Visitable<Cargo> {
	private String descricao;

	@Override
	public void accept(Visitor<Cargo, ?> visitor) {
		visitor.visit(this);
	}
}
