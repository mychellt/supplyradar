package br.com.supplyradar.persistence.model.commons;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="id")
@Table(name = "pessoa_juridica", schema = "supplyradar")
public class PessoaJuridicaEntity extends PessoaEntity {
	
	@Column(name = "cnpj", unique = true, nullable = false)
	private String cnpj;

	@Column(name = "inscricao_estadual")
	private String inscricaoEstadual;
	
	@Column(name = "nome_fantasia")
	private String nomeFantasia;

	@Column(name = "website")
	private String website;
	
	@Column(name = "razao_social")
	private String razaoSocial;
}
