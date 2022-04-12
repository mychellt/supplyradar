package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class Empresa extends AbstractDomainObject<UUID> {
	private SituacaoCadastro situacaoCadastro;
	private Integer descontoPrimeiraAnuidade;
	private Integer descontoSegundaAnuidade;
	private Integer descontoTerceiraAnuidade;
	private String pendencia;
}
