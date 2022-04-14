package br.com.supplyradar.persistence.model.commons;

import br.com.supplyradar.persistence.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;


@Setter
@Getter
@Table(name = "cidade", schema = "supplyradar")
@Entity
public class CidadeEntity extends AbstractEntity<UUID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_unidade_federativa")
    private UnidadeFederativaEntity unidadeFederativa;

}
