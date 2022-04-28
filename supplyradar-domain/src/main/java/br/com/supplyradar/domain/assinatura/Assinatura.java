package br.com.supplyradar.domain.assinatura;

import br.com.supplyradar.domain.commons.Vigencia;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public abstract class Assinatura {
    private TipoAssinatura tipo;
    private Vigencia vigencia;
    private BigDecimal valorOriginal;
    private BigDecimal desconto;
    private BigDecimal valor;
    private BigDecimal reajuste;
    private Status status;

    public enum Status {
        CURRENT, DESCONTINUED, PENDANT;
    }

}
