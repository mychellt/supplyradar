package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.suporte.Chamado;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VinculoUsina extends Vinculo {
	private Usina usina;
	private Cargo cargo;
	private Set<Chamado> chamados;
}
