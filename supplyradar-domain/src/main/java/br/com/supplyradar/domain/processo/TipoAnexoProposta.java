package br.com.supplyradar.domain.processo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TipoAnexoProposta {
	PROPOSTA_COMERCIAL("Proposta Comercial"),
	PROPOSTA_TECNICA("Proposta Técnica"),
	REQUISITO_PRESTACAO_SERVICO("Requisito para Prestação do Serviço"),
	OUTROS("Outros");

	@Getter
	private final String denominacao;
}
