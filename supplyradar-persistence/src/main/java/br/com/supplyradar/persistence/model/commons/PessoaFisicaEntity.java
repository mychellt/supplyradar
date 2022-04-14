package br.com.supplyradar.persistence.model.commons;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name = "pessoa_fisica", schema = "supplyradar")
public class PessoaFisicaEntity extends PessoaEntity {
	@Column(nullable=false)
	private String nome;

	@Column(name="cpf_passaporte", nullable = false)
	private String cpfPassaporte;
	
	@Column(nullable = false, columnDefinition="boolean default false")
	private boolean passaporte;
}
