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
public class CategoriaFornecedor extends AbstractDomainObject<UUID> implements Visitable<CategoriaFornecedor> {
	private TipoPrestacaoServico tipoPrestacaoServico;
	private SetorCategoria setorCategoria;
	private Categoria categoria;
	private Fornecedor fornecedor;

	@Override
	public void accept(Visitor<CategoriaFornecedor, ?> visitor) {
		visitor.visit(this);
	}
}