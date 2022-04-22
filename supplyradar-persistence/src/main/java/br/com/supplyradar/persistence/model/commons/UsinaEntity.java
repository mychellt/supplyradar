package br.com.supplyradar.persistence.model.commons;

import br.com.supplyradar.domain.assinatura.Contrato;
import br.com.supplyradar.domain.commons.TipoUsina;
import br.com.supplyradar.persistence.model.assinatura.ContratoEntity;
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
@Table(name = "usina", schema = "supplyradar")
public class UsinaEntity extends EmpresaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "website")
	private String website;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private TipoUsina tipo;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pessoa")
	private PessoaEntity pessoa;

	@Column(name = "nome")
	private String nome;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_contrato")
	private ContratoEntity contrato;

//	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "usina")
//	private List<VinculoUsinaEntity> vinculos;
}
