package br.com.supplyradar.domain.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoUsuario {
	USINA("Usina"), FORNECEDOR("Fornecedor"), OPERADOR("Operador");

	private final String value;
}
