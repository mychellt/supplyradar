package br.com.supplyradar.domain.commons;

import br.com.supplyradar.domain.assinatura.ContratoUsina;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usina extends Empresa {
	private String website;
	private Float potencia;
	private TipoUsina tipoUsina;
	private SubTipoUsina subTipoUsina;
	private Pessoa pessoa;
	private String nome;
	private Usuario administrador;
	private String certificacoes;
	private String treinamentos;
	private String outrasContratacoes;
	private String art;
	private List<VinculoUsuarioUsina> vinculos;
	private List<Departamento> departamentos;
	private List<Aerogerador> aerogeradores;
	private Substacao substacao;
	private RedeMediaTensao redeMediaTensao;
	private LinhaTransmissao linhaTransmissao;
	private ContratoUsina contrato;
	private Date dataLimiteAvaliacao;
}
