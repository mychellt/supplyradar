package br.com.supplyradar.domain.processo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StatusFase {
	AGUARDANDO("Aguardando"),
	DESCONTINUADO("Descontinuado"),
	NAO_INTERESSADO("Não interessado"),
	ENVIADO("Enviado"),
	AJUSTE_SOLICITADO("Ajuste solicitado"),
	NAO_APROVADO("Não aprovado"),
	APROVADO("Aprovado"),
	EXECUTADO("Executado"),
	INTERESSADO("Interessado"),
	CANCELADO("Cancelado"),
	EM_ANALISE("Em análise");

	@Getter
	private final String nome;

	public String getStyle() {
		if(this.equals(AGUARDANDO)) {
			return "label-info";
		}
		if(this.equals(EM_ANALISE)) {
			return "label-info";
		}
		if(this.equals(INTERESSADO)) {
			return "label-success";
		}
		if(this.equals(APROVADO)) {
			return "label-success";
		}
		if(this.equals(ENVIADO)) {
			return "label-success";
		}
		if(this.equals(EXECUTADO)) {
			return "label-success";
		}
		if(this.equals(CANCELADO)) {
			return "label-warning";
		}
		return "label-default";
	}
	
	public boolean isAguardando() {
		return this.equals(AGUARDANDO);
	}

}
