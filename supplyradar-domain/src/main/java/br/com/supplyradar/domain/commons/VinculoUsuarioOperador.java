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
public class VinculoUsuarioOperador extends VinculoUsuario {
	private String email;
	private Set<Chamado> chamados;
}