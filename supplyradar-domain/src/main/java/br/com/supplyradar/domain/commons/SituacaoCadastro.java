package br.com.supplyradar.domain.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum SituacaoCadastro {
	AGUARDANDO_VALIDACAO_CADASTRO("Aguardando validação do cadastro"),
	CADASTRO_NAO_VALIDADO("Cadastro não validado"),
	CADASTRO_BLOQUEADO("Cadastro Bloqueado"),
	AGUARDANDO_ESCOLHA_ANUIDADE("Aguardando escolha da anuidade"),
	AGUARDANDO_ASSINATURA_CONTRATO("Aguardando assinatura do contrato"),
	AGUARDANDO_VALIDACAO_CONTRATO("Aguardando validação do contrato"),
	CONTRATO_NAO_VALIDADO("Contrato não validado"),
	AGUARDANDO_GERACAO_BOLETO("Aguardando gerar boleto"),
	AGUARDANDO_CONFIRMACAO_PAGAMENTO("Aguardando confirmação de pagamento"),
	BLOQUEADO_FALTA_PAGAMENTO("Bloqueado - Aguardando pagamento"),
	CONTRATO_VALIDADO("Contrato validado"),
	BLOQUEADO_TEMPORARIAMENTE("Bloqueado Temporariamente");

	@Getter
	private final String descricao;
}
