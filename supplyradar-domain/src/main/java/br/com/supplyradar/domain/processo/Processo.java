package br.com.supplyradar.domain.processo;

import br.com.supplyradar.domain.AbstractDomainObject;
import br.com.supplyradar.domain.commons.Categoria;
import br.com.supplyradar.domain.commons.Pessoa;
import br.com.supplyradar.domain.commons.RequisitoPrestacaoServicoProcesso;
import br.com.supplyradar.domain.visitors.Visitable;
import br.com.supplyradar.domain.visitors.Visitor;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Processo extends AbstractDomainObject<UUID> implements Visitable<Processo> {
	private Numeracao numeracao;
	private Date dataAtendimentoSolicitacao;
	private Date dataLimiteApresentacaoProposta;
	private String descricao;
	private String recomendacoes;
	private String descricaoPecas;
	private BigDecimal valor;
	private TipoProcesso tipo;
	private List<InteresseFornecedor> interesses;
	private Categoria categoria;
	private Pessoa contratante;
	private Boolean apresentarInformacoesTecnicas;
	private Boolean desejaFornecimentoPecas;
	private Boolean desejaReceberVisitaTecnica;
	private Date inicioAtendimentoSolicitacao;
	private Date terminoAtendimentoSolicitacao;
	private Date inicioVisitaTecnica;
	private Date terminoVisitaTecnica;
	private List<RequisitoPrestacaoServicoProcesso> requisitosPrestacaoServicoProcesso;
	private List<RequisitoFaturamentoProcesso> requisitosFaturamento;
	private StatusProcesso statusProcesso;
	private boolean mostrarPainelSolarEolico;
	private boolean mostrarRedeMediaTensao;
	private boolean mostrarSubestacao;
	private boolean mostrarLinhaTransmissao;
	private List<AnexoProcesso> anexos;
	private String justificativaCancelamento;
	private List<FaseProcesso> fases;
	private List<StatusProcesso> statusBusca;

	@Override
	public void accept(Visitor<Processo, ?> visitor) {
		visitor.visit(this);
	}
}
