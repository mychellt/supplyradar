package br.com.supplyradar.domain.suporte;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum StatusChamado {
	
	ABERTO("Aberto"),
	FINALIZADO("Finalizado"),
	REABERTO("Reaberto"),
	AGUARDANDO_RETORNO("Aguardando Retorno");
	
	private final String descricao;
}
