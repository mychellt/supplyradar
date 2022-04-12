package br.com.supplyradar.domain.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TipoEstrutura {
	METALICA("Metálica"), EM_CONCRETO("Em concreto");

	@Getter
	private final String descricao;
}
