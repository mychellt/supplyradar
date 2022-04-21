package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.assinatura.ContratoUsina;
import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usina extends Empresa {
	private String website;
	private TipoUsina tipo;
	private Pessoa pessoa;
	private String nome;
	private List<VinculoUsuarioUsina> vinculos;
	private ContratoUsina contrato;
}
