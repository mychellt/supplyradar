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
public class Aerogerador extends AbstractDomainObject<UUID> implements Visitable<Aerogerador> {
	private String fabricante;
	private String modelo;
	private BigDecimal potenciaNominal;
	private Integer quantidade;
	private Usina usina;

	@Override
	public void accept(Visitor<Aerogerador, ?> visitor) {
		visitor.visit(this);
	}
}
