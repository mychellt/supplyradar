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
public class Produto extends AbstractDomainObject<UUID> implements Visitable<Produto> {
	private Categoria categoria;
	private Fornecedor fornecedor;
	private TipoServicoPrestado tipoServicoPrestado;
	private Categoria raizPrecificacao;
	private Categoria categoriaDetalhamentoIdentificacao;

	@Override
	public void accept(Visitor<Produto, ?> visitor) {
		visitor.visit(this);
	}
}
