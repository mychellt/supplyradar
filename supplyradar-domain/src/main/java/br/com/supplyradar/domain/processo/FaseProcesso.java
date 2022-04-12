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
public class FaseProcesso extends AbstractDomainObject<UUID> implements Visitable<FaseProcesso> {
	private Processo processo;
	private Fase fase;
	private StatusFase status;
	private boolean atual;

	@Override
	public void accept(Visitor<FaseProcesso, ?> visitor) {
		visitor.visit(this);
	}
}
