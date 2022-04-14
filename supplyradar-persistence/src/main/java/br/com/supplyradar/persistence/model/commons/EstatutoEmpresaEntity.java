package br.com.supplyradar.persistence.model.commons;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="estatuto_empresa")
@DynamicUpdate
public class EstatutoEmpresaEntity extends ArquivoEntity {
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private PessoaEntity pessoa;
}
