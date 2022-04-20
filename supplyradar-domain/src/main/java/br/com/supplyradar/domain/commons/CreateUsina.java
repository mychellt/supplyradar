package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUsina extends AbstractDomainObject<UUID> implements Visitable<CreateUsina> {
    private String cnpj;
    private String inscricaoEstadual;
    private String razaoSocial;
    private String website;
    private Endereco endereco;

    @Override
    public void accept(Visitor<CreateUsina, ?> visitor) {
        visitor.visit(this);
    }
}
