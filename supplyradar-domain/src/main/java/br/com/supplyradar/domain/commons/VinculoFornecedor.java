package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.suporte.Chamado;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VinculoFornecedor extends Vinculo {
	private Fornecedor fornecedor;
	private Cargo cargo;
	private Set<Chamado> chamados;
}