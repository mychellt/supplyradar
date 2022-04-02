package br.com.supplyradar.persistence.model.commons;

import br.com.supplyradar.domain.commons.TipoAtribuicao;
import br.com.supplyradar.persistence.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Table(name = "permissao", schema = "supplyradar")
@Entity
public class PermissaoEntity extends AbstractEntity<UUID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "sigla", nullable = false)
    private String sigla;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoAtribuicao tipo;

    @Column(name = "ordem")
    private Integer ordem;
}
