package br.com.supplyradar.domain.commons;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SetorAtuacao {

	EOLICA_ONSHORE("Eólica OnShore"),
	SOLAR_FOTOVOLTAICA_CENTRALIZADA("Solar fotovoltaica centralizada");

	@Getter
	private final String denominacao;
}
