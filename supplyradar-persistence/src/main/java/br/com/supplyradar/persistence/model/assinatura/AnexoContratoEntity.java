package br.com.supplyradar.persistence.model.assinatura;

import br.com.supplyradar.domain.assinatura.TipoAnexoContrato;
import br.com.supplyradar.persistence.model.commons.ArquivoEntity;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name="anexo_contrato", schema = "supplyradar")
@DynamicUpdate
public class AnexoContratoEntity extends ArquivoEntity {

	@ManyToOne
	@JoinColumn(name="id_contrato")
	private ContratoEntity contrato;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false)
	private TipoAnexoContrato tipo;
}
