package br.com.supplyradar.domain.processo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StatusProposta {
	ENVIADA("Enviada"),
	REPROVADA("Reprovada"),
	APROVADA("Aprovada"),
	AJUSTE_SOLICITADO("Ajuste Solicitado"),
	DESCONTINUADA("Descontinuada"),
	CANCELADA("Cancelada");

	@Getter
	private final String denominacao;
}
