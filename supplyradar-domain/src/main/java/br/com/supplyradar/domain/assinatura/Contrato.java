package br.com.supplyradar.domain.assinatura;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.commons.Vigencia;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public abstract class Contrato extends AbstractDomainObject<UUID> {
	private Vigencia vigencia;
	private List<AnexoContrato> anexos;
}
