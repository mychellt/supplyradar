package br.com.supplyradar.domain.assinatura;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TipoAssinatura {
	ANUAL(12,"12 meses"),
	BIENAL(24, "24 meses"),
	TRIENAL(36,"36 meses"),
	SEMESTRAL(6,"6 meses"),
	QUINQUIMESTRAL(5,"5 meses"),
	QUADRIMESTRAL(4, "4 meses"),
	TRIMESTRAL(3, "3 meses"),
	BIMESTRAL(2, "2 meses"),
	MENSAL(1, "1 mês"),
	INDETERMINATE(-1, "Até a primeira contratação");

	@Getter
	private final int quantidade;

	@Getter
	private final String descricao;
}
