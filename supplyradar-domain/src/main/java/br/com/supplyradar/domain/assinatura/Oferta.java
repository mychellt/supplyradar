package br.com.supplyradar.domain.assinatura;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.commons.Pessoa;
import br.com.supplyradar.domain.processo.TipoCategoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import static java.util.Optional.ofNullable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Oferta extends AbstractDomainObject<UUID> {
    private BigDecimal valor;
    private int quantidadeServicosPermitida;
    private TipoAssinatura tipoAssinatura;
    private TipoCategoria tipoCategoria;
    private boolean ilimitado;
    private BigDecimal taxa;
    private Pessoa pessoa;
    private Date validade;

    public boolean isOfertaProduto() {
        return ofNullable(tipoCategoria).map(it -> it.equals(TipoCategoria.PRODUTO)).orElse(false);
    }

    public boolean isOfertaServico() {
        return ofNullable(tipoCategoria).map(it -> it.equals(TipoCategoria.PRODUTO)).orElse(false);
    }
}
