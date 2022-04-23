package br.com.supplyradar.persistence.model.commons;

import br.com.supplyradar.domain.commons.SetorAtuacao;
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
@Table(name = "servico", schema = "supplyradar")
public class ServicoEntity extends AbstractEntity<UUID> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "id_categoria",nullable = false)
	private CategoriaEntity categoria;

	@ManyToOne
	@JoinColumn(name = "id_fornecedor",nullable = false)
	private FornecedorEntity fornecedor;

	@ElementCollection(fetch = FetchType.EAGER, targetClass = SetorAtuacao.class)
	@Enumerated(EnumType.STRING)
	@CollectionTable(name="servico_setor", joinColumns = {@JoinColumn(name="servico_id")})
	private List<SetorAtuacao> setores;
}
