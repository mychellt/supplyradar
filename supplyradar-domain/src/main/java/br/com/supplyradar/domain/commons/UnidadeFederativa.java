package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.DomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeFederativa extends AbstractDomainObject<UUID> implements DomainObject, Comparable<UnidadeFederativa>, Visitable<UnidadeFederativa> {
	private String nome;
	private String sigla;
	private boolean selecionado;
	private boolean desabilitado;
	private Long quantidade;

	@Override
	public void accept(Visitor<UnidadeFederativa, ?> visitor) {
		visitor.visit(this);
	}

	@Override
	public int compareTo(UnidadeFederativa o) {
		return 0;
	}
}
