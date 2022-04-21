package br.com.supplyradar.persistence.model.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@Entity
@Table(name = "vinculo_usina", schema = "supplyradar")
public abstract class VinculoUsinaEntity extends VinculoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "id_usina")
	private UsinaEntity usina;
}
