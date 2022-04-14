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
public class Cidade extends AbstractDomainObject<UUID> implements Visitable<Cidade>, Comparable<Cidade> {
	private UnidadeFederativa unidadeFederativa;
	private String nome;

	@Override
	public void accept(Visitor<Cidade, ?> visitor) {
		visitor.visit(this);
	}

	@Override
	public int compareTo(Cidade o) {
		return 0;
	}
}
