package br.com.supplyradar.domain.processo;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Proposta extends AbstractDomainObject<UUID> implements Visitable<Proposta> {
    private int prazoEntrega;
    private int validade;
    private BigDecimal valor;
    private String justificativa;
    private boolean ciente;
    private boolean declarado;
    private StatusProposta situacao;
    private String solicitacaoAjuste;
    private InteresseFornecedor interesse;
    private List<AnexoProposta> anexos;
    private boolean valida;
    private JustificativaReprovacaoProposta justificativaReprovacao;

    @Override
    public void accept(Visitor<Proposta, ?> visitor) {
        visitor.visit(this);
    }
}
