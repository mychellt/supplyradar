package br.com.supplyradar.persistence.model.assinatura;

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
@Table(name = "contrato_usina", schema = "supplyradar")
public class ContratoUsinaEntity extends ContratoEntity {
	@ManyToOne
	@JoinColumn(name = "id_usina")
	private UsinaEntity usina;
}

