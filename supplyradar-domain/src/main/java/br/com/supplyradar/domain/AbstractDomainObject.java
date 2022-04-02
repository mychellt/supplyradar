package br.com.supplyradar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractDomainObject<K> implements Serializable {

	private K id;

	private LocalDateTime dateOfChange;

	private LocalDateTime dateOfCreate;

	private boolean ativo = true;

	public boolean isNew() {
		return getId() == null;
	}
}
