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
public class Servico  extends AbstractDomainObject<UUID> implements Visitable<Servico> {
	private Categoria categoria;
	private Fornecedor fornecedor;
	private TipoPrestacaoServico tipoPrestacaoServico;
	private Categoria raizPrecificacao;
	private Categoria categoriaDetalhamentoIdentificacao;

	@Override
	public void accept(Visitor<Servico, ?> visitor) {
		visitor.visit(this);
	}
}
