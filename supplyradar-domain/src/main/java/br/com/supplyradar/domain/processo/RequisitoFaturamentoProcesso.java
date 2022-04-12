package br.com.supplyradar.domain.processo;

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
public class RequisitoFaturamentoProcesso extends AbstractDomainObject<UUID> implements Visitable<RequisitoFaturamentoProcesso> {
	private Processo processo;
	private RequisitoFaturamento requisitoFaturamento;

	@Override
	public void accept(Visitor<RequisitoFaturamentoProcesso, ?> visitor) {
		visitor.visit(this);
	}
}
