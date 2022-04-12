package br.com.supplyradar.domain.processo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TipoCategoria {
	
	SERVICO("Serviço"), PRODUTO("Produto");

	@Getter
	private final String descricao;

	public boolean isProduto() {
		return this.equals(TipoCategoria.PRODUTO);
	}
	
	public boolean isServico() {
		return this.equals(TipoCategoria.SERVICO);
	}
}
