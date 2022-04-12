package br.com.supplyradar.domain.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TipoRedeTransmissao {
	AEREA("Aérea"), SUBTERRANEA("Subterrânea"), MISTA("Mista");

	@Getter
	private final String descricao;
}
