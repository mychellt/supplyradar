package br.com.supplyradar.persistence.model.commons;

import br.com.supplyradar.persistence.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;


@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "arquivo", schema = "supplyradar")
@Entity
public abstract class ArquivoEntity extends AbstractEntity<UUID> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private UUID id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "content_type")
	private String contentType;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "path")
	private String path;
}
