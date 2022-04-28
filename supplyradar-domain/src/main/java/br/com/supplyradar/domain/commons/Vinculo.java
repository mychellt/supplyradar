package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
public abstract class Vinculo extends AbstractDomainObject<UUID> {
	private String email;
	private List<PermissaoVinculo> permissoes;
	private boolean bloqueado;
}
