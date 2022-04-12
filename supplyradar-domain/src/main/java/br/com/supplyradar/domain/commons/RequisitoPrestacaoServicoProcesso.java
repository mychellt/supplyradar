package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.processo.Processo;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequisitoPrestacaoServicoProcesso extends AbstractDomainObject<UUID> implements Visitable<RequisitoPrestacaoServicoProcesso> {
	private Processo processo;
	private RequisitoPrestacaoServico requisitoPrestacaoServico;

	@Override
	public void accept(Visitor<RequisitoPrestacaoServicoProcesso, ?> visitor) {
		visitor.visit(this);
	}
}
