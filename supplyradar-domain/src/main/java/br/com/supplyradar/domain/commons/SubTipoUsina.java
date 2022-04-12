package br.com.supplyradar.domain.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SubTipoUsina {

	PROSPECCAO_PROJETO("Prospecção e/ou Projeto");

	@Getter
	private final String denominacao;
}
