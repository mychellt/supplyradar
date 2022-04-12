package br.com.supplyradar.domain.suporte;

import br.com.supplyradar.domain.commons.Arquivo;
import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArquivoChamado extends Arquivo {
	private LogChamado logChamado;
}
