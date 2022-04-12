package br.com.supplyradar.domain.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SetorCategoria {

	EOLICA("Eólica"), SOLAR("Solar"), EOLICA_SOLAR("Eólica e Solar");

	@Getter
	private final String descricao;

}
