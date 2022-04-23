package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.suporte.Chamado;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VinculoOperador extends Vinculo {
	private String email;
	private Set<Chamado> chamados;
}