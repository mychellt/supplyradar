package br.com.supplyradar.domain.processo;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.commons.ClassificacaoProposta;
import br.com.supplyradar.domain.commons.Fornecedor;
import br.com.supplyradar.domain.commons.StatusInteresseFornecedor;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InteresseFornecedor extends AbstractDomainObject<UUID> implements Visitable<InteresseFornecedor> {
	private Processo processo;
	private Fornecedor fornecedor;
	private JustificativaRecusaParticipacaoProcesso justificativa;
	private String justificativaInformada;
	private StatusInteresseFornecedor situacao;
	private List<Proposta> propostas;
	private ClassificacaoProposta classificacao;
	private List<FaseInteresse> fases;
	private Proposta proposta;

	@Override
	public void accept(Visitor<InteresseFornecedor, ?> visitor) {
		visitor.visit(this);
	}
}
