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
public class LinhaTransmissao extends AbstractDomainObject<UUID> implements Visitable<LinhaTransmissao> {
	private TensaoLadoAlta classeTensao;
	private TipoEstrutura estrutura;
	private TipoIsolador isolador;
	private String descricaoCaboCondutor;
	private String descricaoCaboPararaios;
	private Usina usina;

	@Override
	public void accept(Visitor<LinhaTransmissao, ?> visitor) {
		visitor.visit(this);
	}
}
