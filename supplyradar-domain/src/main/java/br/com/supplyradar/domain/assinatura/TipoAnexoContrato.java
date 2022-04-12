package br.com.supplyradar.domain.assinatura;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TipoAnexoContrato {
	MODELO("Modelo"),
	ASSINADO("Assinado"),
	ESTATUTO("Estatuto da Empresa");

	@Getter
	private final String descricao;
}
