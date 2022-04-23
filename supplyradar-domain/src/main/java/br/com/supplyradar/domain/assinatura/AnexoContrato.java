package br.com.supplyradar.domain.assinatura;

import br.com.supplyradar.domain.commons.Arquivo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnexoContrato extends Arquivo {
	private Contrato contrato;
	private TipoAnexoContrato tipo;
}
