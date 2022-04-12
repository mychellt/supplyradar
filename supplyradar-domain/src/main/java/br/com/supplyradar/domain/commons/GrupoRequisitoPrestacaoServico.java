package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
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
public class GrupoRequisitoPrestacaoServico extends AbstractDomainObject<UUID> implements Visitable<GrupoRequisitoPrestacaoServico> {
	private String denominacao;
	private String descricao;
	private List<RequisitoPrestacaoServico> requisitos;
	private List<RequisitoPrestacaoServicoFornecedor> requisitosFornecedor;

	@Override
	public void accept(Visitor<GrupoRequisitoPrestacaoServico, ?> visitor) {
		visitor.visit(this);
	}
}
