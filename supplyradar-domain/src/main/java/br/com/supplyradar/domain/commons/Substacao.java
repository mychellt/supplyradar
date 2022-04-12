package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Substacao extends AbstractDomainObject<UUID> implements Visitable<Substacao> {
	private BigDecimal tensaoLadoBaixa;
	private BigDecimal tensaoLadoAlta;
	private Usina usina;

	@Override
	public void accept(Visitor<Substacao, ?> visitor) {
		visitor.visit(this);
	}
}
