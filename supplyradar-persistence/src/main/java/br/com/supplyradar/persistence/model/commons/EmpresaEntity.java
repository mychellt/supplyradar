package br.com.supplyradar.persistence.model.commons;

import br.com.supplyradar.domain.commons.SituacaoCadastro;
import br.com.supplyradar.persistence.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import java.util.UUID;


@Setter
@Getter
@MappedSuperclass
public abstract class EmpresaEntity extends AbstractEntity<UUID> {
	private static final long serialVersionUID = -1630530310247607652L;

	@Column(name="situacao_cadastro")
	@Enumerated(EnumType.STRING)
	protected SituacaoCadastro situacao;
}
