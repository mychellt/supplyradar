package br.com.supplyradar.domain.assinatura;

import br.com.supplyradar.domain.commons.Usina;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContratoUsina extends Contrato {
	private Usina usina;
}
