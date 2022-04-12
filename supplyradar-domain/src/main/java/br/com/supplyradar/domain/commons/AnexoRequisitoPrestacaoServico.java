package br.com.supplyradar.domain.commons;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnexoRequisitoPrestacaoServico extends Arquivo{
	private RequisitoPrestacaoServicoFornecedor requisitoPrestacaoServicoFornecedor;
}
