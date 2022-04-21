package br.com.supplyradar.persistence.model.commons;

import br.com.supplyradar.persistence.model.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "unidade_federativa", schema = "supplyradar")
@Entity
public class UnidadeFederativaEntity extends AbstractEntity<UUID> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String sigla;
}
