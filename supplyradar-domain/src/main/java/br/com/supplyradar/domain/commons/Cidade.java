package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.DomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cidade implements DomainObject, Visitable<Cidade>, Comparable<Cidade> {
	private Long id;
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
