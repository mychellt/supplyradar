package br.com.supplyradar.domain.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TensaoLadoAlta {
	LDA_500KV("500kv"),
	LDA_230KV("230kv"),
	LDA_138KV("138kv"),
	LDA_69KV("69kv"),
	LDA_34_5KV("34,5kv"),
	LDA_13_8KV("13,8kv");
	
	private final String descricao;
}
