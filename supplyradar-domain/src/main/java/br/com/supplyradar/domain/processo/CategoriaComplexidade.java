package br.com.supplyradar.domain.processo;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.commons.Categoria;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaComplexidade extends AbstractDomainObject<UUID> implements Visitable<CategoriaComplexidade> {
	private Integer leadTime;
	private Integer dificuldadeEncontrar;
	private Integer valorAgregado;
	private Categoria categoria;

	@Override
	public void accept(Visitor<CategoriaComplexidade, ?> visitor) {
		visitor.visit(this);
	}
}
