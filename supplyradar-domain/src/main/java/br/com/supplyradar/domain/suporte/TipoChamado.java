package br.com.supplyradar.domain.suporte;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TipoChamado {

	DUVIDA("Dúvida"),
	SUGESTAO("Sugestão"),
	ERRO("Erro");

	@Getter
	private final String descricao;
}
