package br.com.supplyradar.domain.assinatura;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.processo.TipoCategoria;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

import static java.util.Optional.ofNullable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PacoteAssinatura extends AbstractDomainObject<UUID> {
    private String descricao;
    private boolean publico;
    private BigDecimal valor;
    private TipoAssinatura tipo;
    private TipoCategoria tipoCategoria;
    private int quantidadeItensPermitido;
    private boolean ilimitado;


    public boolean isIndeterminado() {
        return ofNullable(tipo).map(it -> it.equals(TipoAssinatura.INDETERMINATE)).orElse(false);
    }
}
