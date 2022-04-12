package br.com.supplyradar.domain.commons;

public enum TipoIsolador {
	PORCELANA("Porcelana"), 
	POLIMERICO("Polimérico");
	
	private String descricao;
	
	private TipoIsolador(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
