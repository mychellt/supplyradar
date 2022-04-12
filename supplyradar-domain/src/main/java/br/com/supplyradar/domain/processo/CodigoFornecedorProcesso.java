package br.com.supplyradar.domain.processo;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.commons.Fornecedor;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CodigoFornecedorProcesso extends AbstractDomainObject<UUID> implements Visitable<CodigoFornecedorProcesso> {
	private String codigo;
	private Fornecedor fornecedor;
	private Processo processo;

	@Override
	public void accept(Visitor<CodigoFornecedorProcesso, ?> visitor) {
		visitor.visit(this);
	}
}
