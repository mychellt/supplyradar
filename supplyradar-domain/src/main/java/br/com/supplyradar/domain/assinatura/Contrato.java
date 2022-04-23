package br.com.supplyradar.domain.assinatura;

import br.com.supplyradar.domain.AbstractDomainObject;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public abstract class Contrato extends AbstractDomainObject<UUID> {
	private Date vigencia;
	private List<AnexoContrato> anexos;
	private String pendencia;
}
