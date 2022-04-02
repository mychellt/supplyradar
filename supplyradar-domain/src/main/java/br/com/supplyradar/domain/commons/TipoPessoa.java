package br.com.supplyradar.domain.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TipoPessoa {
	PESSOA_FISICA("PESSOA FÍSICA"), 
	PESSOA_JURIDICA("PESSOA JURÍDICA");

	private final String value;

}
