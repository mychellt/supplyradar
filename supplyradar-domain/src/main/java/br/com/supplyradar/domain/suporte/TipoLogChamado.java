package br.com.supplyradar.domain.suporte;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum TipoLogChamado {

	ABERTURA("Abertura de Chamado"),
	TRANSFERENCIA("Transferência de Responsabilidade") ,
	ANDAMENTO("Andamento");

	@Getter
	private final String descricao;

}
