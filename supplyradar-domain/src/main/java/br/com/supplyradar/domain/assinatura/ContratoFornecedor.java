package br.com.supplyradar.domain.assinatura;

import br.com.supplyradar.domain.commons.Fornecedor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContratoFornecedor extends Contrato {
	private Fornecedor fornecedor;
}
