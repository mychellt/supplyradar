package br.com.supplyradar.domain.suporte;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.commons.VinculoUsuario;
import br.com.supplyradar.domain.commons.VinculoUsuarioOperador;
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
public class Chamado extends AbstractDomainObject<UUID> implements Visitable<Chamado> {
	private VinculoUsuario usuarioChamado;
	private VinculoUsuarioOperador operadorChamado;
	private String assunto;
	private Set<LogChamado> logs;
	private TipoChamado tipo;
	private StatusChamado statusChamado;
	private boolean showAtribuirModal;

	@Override
	public void accept(Visitor<Chamado, ?> visitor) {
		visitor.visit(this);
	}
}
