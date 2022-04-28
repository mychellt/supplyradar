package br.com.supplyradar.domain.agenda;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TipoEvento {
	PROCESSO_ATENDIMENTO_SOLICITACAO("Processo", "-style-evento-processo-agenda"),
	VISITA_TECNICA("Visita técnica", "-style-evento-visita-tecnica"),
	APRESENTACAO_PROPOSTA("Apresentação de propostas", "-style-evento-proposta"),
	APROVACAO_PROPOSTA("Aprovação de proposta", "-style-evento-proposta"),
	PAGAMENTO_SERVICO("Pagamento de serviço", "-style-evento-pagamento-servico"),
	OUTROS("Outros", ""),
	ORDEM_COMPRA("Ordem Compra", "-style-evento-ordem-compra"),
	DOCUMENTACAO("Documentação", "-style-evento-documentacao"),
	CONTRATO_ADITIVO("Contrato/Aditivo", "-style-evento-contrato-aditivo");

	@Getter
	private final String descricao;

	@Getter
	private final String style;

}
