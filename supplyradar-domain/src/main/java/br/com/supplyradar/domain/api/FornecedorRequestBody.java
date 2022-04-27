package br.com.supplyradar.domain.api;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.commons.Endereco;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FornecedorRequestBody extends AbstractDomainObject<UUID> implements Visitable<FornecedorRequestBody> {
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String telefone;
    private String inscricaoEstadual;
    private String website;
    private Endereco endereco;
    private String experiencias;
    private String fornecimentos;
    private boolean atendimento24horas;


    @Override
    public void accept(Visitor<FornecedorRequestBody, ?> visitor) {
        visitor.visit(this);
    }
}
