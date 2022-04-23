package br.com.supplyradar.domain.commons;


import br.com.supplyradar.domain.assinatura.ContratoFornecedor;
import br.com.supplyradar.domain.processo.IdContratacao;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fornecedor extends Empresa implements Visitable<Fornecedor> {
	private Atuacao atuacao;
	private Atendimento atendimento;
	private Pessoa pessoa;
	private List<VinculoFornecedor> vinculos;
	private List<Servico> servicos;
	private List<Produto> produtos;
	private Usuario administrador;
	private ContratoFornecedor contrato;

	@Override
	public void accept(Visitor<Fornecedor, ?> visitor) {
		visitor.visit(this);
	}
}
