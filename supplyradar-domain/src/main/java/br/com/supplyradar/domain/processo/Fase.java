package br.com.supplyradar.domain.processo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Fase {
	SELECAO("Seleção"),
	CONTRATACAO("Contratação"),
	EXECUCAO("Execução"),
	AVALIAÇÃO("Avaliação"),
	ENVIO_PROPOSTA("Envio de proposta"),
	ANALISE_PROPOSTA("Análise de propsota");

	@Getter
	private final String denominacao;

	public boolean isSelecao() {
		return this.equals(SELECAO);
	}
	public boolean isContratacao() {
		return this.equals(CONTRATACAO);
	}
	public boolean isExecucao() {
		return this.equals(EXECUCAO);
	}
	public boolean isEnvioProposta() {
		return this.equals(ENVIO_PROPOSTA);
	}
	public boolean isAnaliseProposta() {
		return this.equals(ANALISE_PROPOSTA);
	}
}
