package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RedeMediaTensao extends AbstractDomainObject<UUID> implements Visitable<RedeMediaTensao> {
	private TensaoLadoBaixa classeTensao;
	private TipoRedeTransmissao tipo;
	private LocalizacaoTrafoUnitario localizacaoTrafoUnitario;
	private Usina usina;

	@Override
	public void accept(Visitor<RedeMediaTensao, ?> visitor) {
		visitor.visit(this);
	}
}
