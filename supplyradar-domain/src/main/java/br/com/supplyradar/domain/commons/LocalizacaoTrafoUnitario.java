package br.com.supplyradar.domain.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LocalizacaoTrafoUnitario {
	NO_AEROGERAOR_NACELLE("No Aerogerador (Nacelle)"),
	NO_AEROGERADOR_BASE("No Aerogerador (Base)"),
	EXTERNO_AO_AEROGERADOR("Externo ao Aerogerador");

	@Getter
	private final String descricao;
}
