package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.DomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco extends AbstractDomainObject<UUID> implements DomainObject, Visitable<Endereco> {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private UUID idCidade;
    private TipoEndereco tipo;
    private UUID idPessoa;

    @Override
    public void accept(Visitor<Endereco, ?> visitor) {
        visitor.visit(this);
    }
}
