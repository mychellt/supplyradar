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
public class RequisitoPrestacaoServico extends AbstractDomainObject<UUID> implements Visitable<RequisitoPrestacaoServico> {
	private String denominacao;
	private String descricao;
	private GrupoRequisitoPrestacaoServico grupoRequisitoPrestacaoServico;
	private Boolean exigeComprovacao;

	@Override
	public void accept(Visitor<RequisitoPrestacaoServico, ?> visitor) {
		visitor.visit(this);
	}
}
