package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequisitoPrestacaoServicoFornecedor extends AbstractDomainObject<UUID> implements Visitable<RequisitoPrestacaoServicoFornecedor> {
	private Date vencimento;
	private RequisitoPrestacaoServico requisitoPrestacaoServico;
	private AnexoRequisitoPrestacaoServico anexoRequisito;

	@Override
	public void accept(Visitor<RequisitoPrestacaoServicoFornecedor, ?> visitor) {
		visitor.visit(this);
	}
}
