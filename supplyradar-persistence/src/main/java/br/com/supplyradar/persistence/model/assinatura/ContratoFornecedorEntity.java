package br.com.supplyradar.persistence.model.assinatura;

import br.com.supplyradar.persistence.model.commons.FornecedorEntity;
import br.com.supplyradar.persistence.model.commons.UsinaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name = "contrato_fornecedor", schema = "supplyradar")
public class ContratoFornecedorEntity extends ContratoEntity {
	@ManyToOne
	@JoinColumn(name = "id_fornecedor")
	private FornecedorEntity fornecedor;
}

