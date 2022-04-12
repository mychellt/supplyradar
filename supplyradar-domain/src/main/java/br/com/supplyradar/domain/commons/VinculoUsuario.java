package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
public abstract class VinculoUsuario extends AbstractDomainObject<UUID> {
	private Usuario usuario;
	private String email;
	private List<AtribuicaoVinculo> atribuicoes;
	private boolean bloqueado;
}
