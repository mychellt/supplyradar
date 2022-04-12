package br.com.supplyradar.domain.suporte;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.Set;
import java.util.UUID;



@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogChamado extends AbstractDomainObject<UUID> implements Visitable<LogChamado> {
	private String msg;
	private Chamado chamado;
	private TipoLogChamado tipoLogChamado;
	private Set<ArquivoChamado> arquivos;

	@Override
	public void accept(Visitor<LogChamado, ?> visitor) {
		visitor.visit(this);
	}
}
