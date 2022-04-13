package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CreateUsuario extends AbstractDomainObject<UUID> implements Visitable<CreateUsuario> {
	private String login;
	private String senha;
	private String email;
	private String emailConfirmacao;
	private String senhaConfirmacao;
	private String tipo;
	private boolean aceitaTermoAdesao;
	private boolean concordaPoliticaPrivacidade;
	private String cpf;
	private String passaporte;
	private boolean estrangeiro;
	private String telefone;
	private String nome;

	@Override
	public void accept(Visitor<CreateUsuario, ?> visitor) {
		visitor.visit(this);
	}
}
