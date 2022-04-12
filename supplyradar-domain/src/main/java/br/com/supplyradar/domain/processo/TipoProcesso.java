package br.com.supplyradar.domain.processo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TipoProcesso {
	CONTRATACAO_SERVICO("Contratação de serviço"),
	AQUISICAO_PRODUTO("Aquisição de produto");

	@Getter
	private final String denominacao;
	
}
