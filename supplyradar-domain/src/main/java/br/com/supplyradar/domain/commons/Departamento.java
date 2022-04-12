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
public class Departamento extends AbstractDomainObject<UUID> implements Visitable<Departamento> {
	private String nome;
	private String responsavel;
	private String telefone;
	private String email;
	private TipoDepartamento tipo;

	@Override
	public void accept(Visitor<Departamento, ?> visitor) {
		visitor.visit(this);
	}
}
