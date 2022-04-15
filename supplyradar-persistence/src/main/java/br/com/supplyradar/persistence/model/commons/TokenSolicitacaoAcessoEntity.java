package br.com.supplyradar.persistence.model.commons;

import br.com.supplyradar.persistence.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Table(name = "token_solicitacao_acesso", schema = "supplyradar")
@Entity
public class TokenSolicitacaoAcessoEntity extends AbstractEntity<UUID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String key;

    @Column(nullable = false)
    private boolean expirado;

    @OneToOne
    @JoinColumn(name="id_solicitacao")
    private SolicitacaoAcessoEntity solicitacao;
}
