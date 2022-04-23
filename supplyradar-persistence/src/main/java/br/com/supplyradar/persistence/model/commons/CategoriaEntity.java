package br.com.supplyradar.persistence.model.commons;

import br.com.supplyradar.domain.commons.SetorAtuacao;
import br.com.supplyradar.domain.processo.TipoCategoria;
import br.com.supplyradar.persistence.model.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "categoria", schema = "supplyradar")
public class CategoriaEntity extends AbstractEntity<UUID> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false)
	private TipoCategoria tipo;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name="categoria_setor", joinColumns = @JoinColumn(name="categoria_id"))
	private List<SetorAtuacao> setores;

	@ManyToOne
	@JoinColumn(name = "id_mae")
	private CategoriaEntity mae;
}
