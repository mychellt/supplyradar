package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class TokenSolicitacaoAcesso extends AbstractDomainObject<UUID> implements Visitable<TokenSolicitacaoAcesso> {
	private String key;
	private SolicitacaoAcesso solicitacao;
	private boolean expirado;

	@Override
	public void accept(Visitor<TokenSolicitacaoAcesso, ?> visitor) {
		visitor.visit(this);
	}
}
