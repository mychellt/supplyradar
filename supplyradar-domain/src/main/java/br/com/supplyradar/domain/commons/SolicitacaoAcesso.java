package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.UUID;


@Setter
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class SolicitacaoAcesso extends AbstractDomainObject<UUID> implements Visitable<SolicitacaoAcesso> {
	private Usuario usuario;

	@Override
	public void accept(Visitor<SolicitacaoAcesso, ?> visitor) {
		visitor.visit(this);
	}
}
