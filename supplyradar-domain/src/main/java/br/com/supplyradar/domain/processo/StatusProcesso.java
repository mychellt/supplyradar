package br.com.supplyradar.domain.processo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StatusProcesso {
	CADASTRADO("Cadastrado"),
	EM_PROCESSO_SELECAO("Em Seleção"),
	EM_PROCESSO_CONTRATACAO("Em Contratação"),
	EM_PROCESSO_AVALIACAO("Em Avaliação"),
	CANCELADO("Cancelado"),
	CONCLUIDO("Concluido"),
	DESCONTINUADO("Descontinuado"),
	ENCERRADO("Encerrado");

	@Getter
	private final String nome;

	public String getStyle() {
		if(this.equals(EM_PROCESSO_SELECAO)){
			return "label-success";
		}
		if(this.equals(DESCONTINUADO)){
			return "label-danger";
		}
		if(this.equals(CANCELADO)){
			return "label-warning";
		}
		return "label-default";
	}
}
