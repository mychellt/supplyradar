package br.com.supplyradar.persistence.model.assinatura;

import br.com.supplyradar.domain.assinatura.TipoAssinatura;
import br.com.supplyradar.domain.commons.Pessoa;
import br.com.supplyradar.domain.processo.TipoCategoria;
import br.com.supplyradar.persistence.model.AbstractEntity;
import br.com.supplyradar.persistence.model.commons.PessoaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfertaEntity extends AbstractEntity<UUID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "quantidade_servicos_permitida")
    private int quantidadeServicosPermitida;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_assinatura")
    private TipoAssinatura tipoAssinatura;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_categoria")
    private TipoCategoria tipoCategoria;

    @Column(name = "ilimitado", nullable = false, columnDefinition = "boolean default false")
    private boolean ilimitado;

    @Column(name = "taxa")
    private BigDecimal taxa;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private PessoaEntity pessoa;

    @Column(name = "validade")
    private LocalDate validade;
}
