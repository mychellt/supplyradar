package br.com.supplyradar.domain.commons;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TensaoLadoBaixa {
	TLB_13_8KV("13,8kv"),
	TLB_34_5KV("34,5kv");

	@Getter
	private final String descricao;
}
