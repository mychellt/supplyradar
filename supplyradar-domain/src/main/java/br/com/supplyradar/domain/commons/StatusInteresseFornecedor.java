package br.com.supplyradar.domain.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StatusInteresseFornecedor {
	AGUARDANDO("Aguardando"), 
	CANCELADO("Cancelado"),
	DESCONTINUADO("Descontinuado"),
	NAO_INTERESSADO("Não Interessado"),
	INTERESSADO("Interessado"),
	PARTICIPACAO_CANCELADA("Participação Cancelada");

	@Getter
	private final String nome;
}
