package br.com.supplyradar.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public abstract class AbstractDomainObject<K> implements Serializable {

	private K id;

	private LocalDateTime dateOfChange;

	private LocalDateTime dateOfCreate;

	private boolean ativo = true;

	public boolean isNew() {
		return getId() == null;
	}
}
