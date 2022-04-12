package br.com.supplyradar.domain.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TipoDepartamento {
	COMERCIAL("Comercial"),
	OPERACIONAL("Operacional"),
	TECNICO("Técnico"),
	OUTROS("Outros");

	@Getter
	private final String denominacao;
}
