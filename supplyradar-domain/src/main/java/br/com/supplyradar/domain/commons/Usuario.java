package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
public class Usuario extends AbstractDomainObject<UUID> implements Visitable<Usuario> {
    private String login;
    private String senha;
    private PessoaFisica pessoa;
    private TipoUsuario tipo;
    private boolean autorizado;
    private List<VinculoUsuario> vinculos;

    @Override
    public void accept(Visitor<Usuario, ?> visitor) {
        visitor.visit(this);
    }
}