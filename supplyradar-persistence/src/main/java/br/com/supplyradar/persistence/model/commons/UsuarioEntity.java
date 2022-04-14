package br.com.supplyradar.persistence.model.commons;

import br.com.supplyradar.domain.commons.TipoUsuario;
import br.com.supplyradar.persistence.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;

@Setter
@Getter
@Table(name = "usuario", schema = "supplyradar")
@Entity
public class UsuarioEntity extends AbstractEntity<UUID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    @ManyToOne(cascade = {PERSIST,MERGE})
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoaEntity pessoa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo;

    @Column(nullable = false)
    private boolean autorizado;
}
