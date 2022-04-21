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
public class UsinaRequestBody extends AbstractDomainObject<UUID> implements Visitable<UsinaRequestBody> {
    private String cnpj;
    private String inscricaoEstadual;
    private String razaoSocial;
    private String website;
    private String nome;
    private String tipo;
    private Endereco endereco;
    private Endereco enderecoCorrespondencia;

    @Override
    public void accept(Visitor<UsinaRequestBody, ?> visitor) {
        visitor.visit(this);
    }
}
