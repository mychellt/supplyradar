package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.processo.CategoriaComplexidade;
import br.com.supplyradar.domain.processo.TipoCategoria;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria extends AbstractDomainObject<UUID> implements Visitable<Categoria> {
	private String descricao;
	private Boolean detalhamentoPrecificacao;
	private Boolean detalhamentoIdentificacao;
	private TipoCategoria tipoCategoria;
	private Categoria mae;
	private CategoriaComplexidade categoriaComplexidade;
	private List<Categoria> filhos;

	@Override
	public void accept(Visitor<Categoria, ?> visitor) {
		visitor.visit(this);
	}
}
