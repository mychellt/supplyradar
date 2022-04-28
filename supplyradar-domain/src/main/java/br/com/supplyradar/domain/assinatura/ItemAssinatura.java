package br.com.supplyradar.domain.assinatura;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.commons.Categoria;
import br.com.supplyradar.domain.processo.TipoCategoria;
import lombok.*;

import java.util.UUID;

import static java.util.Objects.nonNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemAssinatura extends AbstractDomainObject<UUID> {
	private Categoria categoria;
	private Assinatura assinatura;
	private TipoCategoria tipo;


	public boolean isItemAnuidadeServico() {
		return nonNull(tipo) && tipo.isServico();
	}

	public boolean isItemAnuidadeProduto() {
		return nonNull(tipo) && tipo.isServico();
	}
}
