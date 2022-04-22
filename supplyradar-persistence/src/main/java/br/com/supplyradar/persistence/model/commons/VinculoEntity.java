package br.com.supplyradar.persistence.model.commons;

import br.com.supplyradar.persistence.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;


@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@Entity
@Table(name = "vinculo", schema = "supplyradar")
public abstract class VinculoEntity extends AbstractEntity<UUID> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "bloqueado", nullable = false)
	private boolean bloqueado;
}
