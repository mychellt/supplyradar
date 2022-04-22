package br.com.supplyradar.persistence.model.assinatura;

import br.com.supplyradar.persistence.model.AbstractEntity;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@Setter
@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "contrato", schema = "supplyradar")
public abstract class ContratoEntity extends AbstractEntity<UUID> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name="vigencia")
	@Temporal(TemporalType.TIMESTAMP)
	private Date vigencia;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "contrato", fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<AnexoContratoEntity> anexos;

	@Column(name = "pendencia")
	private String pendencia;
}

