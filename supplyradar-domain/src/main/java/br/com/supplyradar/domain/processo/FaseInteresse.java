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
public class FaseInteresse extends AbstractDomainObject<UUID> implements Visitable<FaseInteresse> {
	private Fase fase;
	private StatusFase status;
	private InteresseFornecedor interesse;
	private boolean atual;

	@Override
	public void accept(Visitor<FaseInteresse, ?> visitor) {
		visitor.visit(this);
	}
}
