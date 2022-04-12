package br.com.supplyradar.domain.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ClassificacaoProposta {
	PRIMEIRO("1º"), SEGUNDO("2º"), TERCEIRO("3º");

	@Getter
	private final String nome;
}
