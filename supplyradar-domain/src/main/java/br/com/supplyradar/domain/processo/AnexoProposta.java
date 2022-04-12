package br.com.supplyradar.domain.processo;


import br.com.supplyradar.domain.commons.Arquivo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnexoProposta extends Arquivo {
	private Proposta proposta;
	private TipoAnexoProposta tipo;
}

