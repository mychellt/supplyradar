package br.com.supplyradar.domain.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TipoUsina {

	EOLICA_ONSHORE("Eólica OnShore"),
	EOLICA_OFFSHORE("Eólica OffShore"),
	SOLAR_FOTOVOLTAICA("Solar Fotovoltaica"),
	SOLAR_HELIOTERMICA("Solar Heliotérmica");

	@Getter
	private final String denominacao;
}
