package br.com.supplyradar.persistence.model.commons;

import br.com.supplyradar.domain.commons.TipoPessoa;
import br.com.supplyradar.persistence.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa", schema = "supplyradar")
@Entity
public abstract class PessoaEntity extends AbstractEntity<UUID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa", fetch=FetchType.LAZY)
    private List<EnderecoEntity> enderecos;
}
