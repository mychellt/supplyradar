package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public abstract class Pessoa extends AbstractDomainObject<UUID> implements Visitable<Pessoa> {
	private TipoPessoa tipo;
	private String telefone;
	private Email email;
	private List<Endereco> enderecos;
	private String confirmarEmail;
}
