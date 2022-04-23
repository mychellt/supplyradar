package br.com.supplyradar.persistence.model.commons;


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
@Table(name = "fornecedor", schema = "supplyradar")
public class FornecedorEntity extends EmpresaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Embedded
	private AtuacaoEntity atuacao;

	@Embedded
	private AtendimentoEntity atendimento;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="id_pessoa")
	private PessoaEntity pessoa;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "fornecedor")
	private List<VinculoFornecedorEntity> vinculos;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "fornecedor")
	private List<ServicoEntity> servicos;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "fornecedor")
	private List<ProdutoEntity> produtos;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="id_administrador")
	private UsuarioEntity administrador;

	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="id_contrato")
	private ContratoEntity contrato;
}
