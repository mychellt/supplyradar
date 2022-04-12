package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.suporte.Chamado;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VinculoUsuarioUsina extends VinculoUsuario {
	private Usina usina;
	private Cargo cargo;
	private Set<Chamado> chamados;
}
