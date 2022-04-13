package br.com.supplyradar.domain.commons;


import br.com.supplyradar.domain.assinatura.ContratoFornecedor;
import br.com.supplyradar.domain.processo.CodigoFornecedorProcesso;
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
	private String descricaoAtuacao;
	private String descricaoResumida;
	private Pessoa pessoa;
	private boolean atendimentoContingencia;
	private boolean atendimento24hrs;
	private String outrasCertificacoes;
	private List<VinculoUsuarioFornecedor> vinculos;
	private List<Servico> servicos;
	private List<Produto> produtos;
	private List<CategoriaFornecedor> categorias;
	private CreateUsuario administrador;
	private ContratoFornecedor contrato;
	private CodigoFornecedorProcesso codigo;

	@Override
	public void accept(Visitor<Fornecedor, ?> visitor) {
		visitor.visit(this);
	}
}
